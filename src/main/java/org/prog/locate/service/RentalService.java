package org.prog.locate.service;

import java.util.List;
import org.prog.locate.entity.Rental;

public interface RentalService {
  Rental createRental(
      Long renterId, Long itemId, java.time.LocalDate startDate, java.time.LocalDate endDate);

  List<Rental> getActiveRentals();

  Rental cancelRental(Long rentalId);

  List<Rental> getRentalsByRenter(Long renterId);
}
