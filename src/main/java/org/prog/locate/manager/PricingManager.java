package org.prog.locate.manager;

import org.prog.locate.entity.RentableItem;
import org.prog.locate.entity.RentalType;

import java.time.LocalDate;

public interface PricingManager {
    Double calculatePrice(RentableItem item, LocalDate startDate, LocalDate endDate, RentalType renterType);
}