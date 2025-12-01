package org.prog.locate.service.impl;

import static org.prog.locate.entity.RentalStatus.ACTIVE;
import static org.prog.locate.entity.RentalStatus.CANCELLED;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prog.locate.entity.Rental;
import org.prog.locate.exception.BusinessException;
import org.prog.locate.exception.ResourceNotFoundException;
import org.prog.locate.manager.PricingManager;
import org.prog.locate.repository.RentableItemRepository;
import org.prog.locate.repository.RentalRepository;
import org.prog.locate.repository.RenterRepository;
import org.prog.locate.service.RentalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

  private final RentalRepository rentalRepository;
  private final RenterRepository renterRepository;
  private final RentableItemRepository itemRepository;
  private final PricingManager pricingManager;

  @Override
  @Transactional
  public Rental createRental(Long renterId, Long itemId, LocalDate startDate, LocalDate endDate) {
    if (endDate.isBefore(startDate)) {
      log.error("End date must be after start date");
      throw new BusinessException("End date must be after start date");
    }

    if (startDate.isBefore(LocalDate.now())) {
      log.error("Start date cannot be in the past");
      throw new BusinessException("Start date cannot be in the past");
    }

    var renter =
        renterRepository
            .findById(renterId)
            .orElseThrow(() -> new ResourceNotFoundException("Renter not found"));

    var item =
        itemRepository
            .findById(itemId)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found"));

    if (!item.isAvailable()) {
      log.error("Item is not available");
      throw new BusinessException("Item is not available");
    }

    var price = pricingManager.calculatePrice(item, startDate, endDate, renter.getType());

    var rental =
        Rental.builder()
            .renter(renter)
            .item(item)
            .startDate(startDate)
            .endDate(endDate)
            .status(ACTIVE)
            .totalPrice(price)
            .createdAt(LocalDateTime.now())
            .build();

    item.setAvailable(false);
    itemRepository.save(item);

    return rentalRepository.save(rental);
  }

  @Override
  public List<Rental> getActiveRentals() {
    return rentalRepository.findByStatus(ACTIVE);
  }

  @Override
  @Transactional
  public Rental cancelRental(Long rentalId) {
    Rental rental =
        rentalRepository
            .findById(rentalId)
            .orElseThrow(() -> new ResourceNotFoundException("Rental not found"));

    if (rental.getStatus() != ACTIVE) {
      throw new BusinessException("Only active rentals can be cancelled");
    }

    // set the item as available again
    rental.getItem().setAvailable(true);
    itemRepository.save(rental.getItem());

    rental.setStatus(CANCELLED);
    return rentalRepository.save(rental);
  }

  @Override
  public List<Rental> getRentalsByRenter(Long renterId) {
    return rentalRepository.findAll().stream()
        .filter(rental -> rental.getRenter().getId().equals(renterId))
        .toList();
  }
}
