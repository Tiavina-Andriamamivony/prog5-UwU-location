package org.prog.locate.manager.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.prog.locate.entity.RentableItem;
import org.prog.locate.entity.RentalType;
import org.prog.locate.exception.BusinessException;
import org.prog.locate.manager.PricingManager;
import org.prog.locate.manager.model.Discount;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PricingManagerImpl implements PricingManager {

  private final List<Discount> discounts =
      List.of(Discount.church(), Discount.school(), Discount.organization(), Discount.individual());

  @Override
  public Double calculatePrice(
      RentableItem item, LocalDate startDate, LocalDate endDate, RentalType renterType) {
    if (endDate.isBefore(startDate)) {
      log.error("End date must be after start date");
      throw new BusinessException("End date must be after start date");
    }

    var days = ChronoUnit.DAYS.between(startDate, endDate);
    if (days < 1) days = 1;

    var basePrice = item.getBasePrice() != null ? item.getBasePrice() : 0.0;
    var total = basePrice * days;

    var discountPercentage =
        discounts.stream()
            .filter(d -> d.getType() == renterType)
            .findFirst()
            .map(Discount::getPercentage)
            .orElse(0.0);

    return total * (1 - discountPercentage);
  }
}
