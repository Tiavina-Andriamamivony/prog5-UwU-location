package org.prog.locate.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Phone extends Article {

    private int conditionPercentage;
    private double deposit;

    public Phone() {
        setType(ArticleType.PHONE);
    }

    @Override
    public Invoice rent(Renter renter) {
        double finalPrice = getPrice() * (conditionPercentage / 100.0);

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
