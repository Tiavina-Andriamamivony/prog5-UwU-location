package org.prog.locate.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Sono extends Article {

    private boolean forEvent;
    private double deposit;

    public Sono() {
        setType(ArticleType.SONO);
    }

    @Override
    public Invoice rent(Renter renter) {
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
