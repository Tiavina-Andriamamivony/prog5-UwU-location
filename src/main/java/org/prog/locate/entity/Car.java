package org.prog.locate.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Car extends Article {

    private boolean validLicense;
    private double deposit;

    public Car() {
        setType(ArticleType.CAR);
    }

    @Override
    public Invoice rent(Renter renter) {
        if (!validLicense) {
            throw new IllegalStateException("Invalid driver's license");
        }
        double finalPrice = getPrice();

        if (renter.getType() == RenterType.PERSON && renter.isLoyalCustomer()) {
            finalPrice *= 0.5;
        } else {
            finalPrice *= 1 - renter.getDiscountPercentage();
        }

        setRentDay(LocalDate.now());
        setReturnDeadline(getRentDay().plusDays(1));

        Invoice invoice = new Invoice(this, renter, deposit);
        invoice.setTotalAmount(finalPrice + deposit);
        return invoice;
    }
}
