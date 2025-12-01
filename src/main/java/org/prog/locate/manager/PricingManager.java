package org.prog.locate.manager;

import java.time.LocalDate;
import org.prog.locate.entity.RentableItem;
import org.prog.locate.entity.RentalType;

public interface PricingManager {
  Double calculatePrice(
      RentableItem item, LocalDate startDate, LocalDate endDate, RentalType renterType);
}
