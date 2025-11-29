package org.prog.locate.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class House extends Article {

    private String address;
    private int minimumNights = 1;
    private double deposit;
    private String rules;

    public House() {
        setType(ArticleType.HOUSE);
    }

    @Override
    public Invoice rent(Renter renter) {
        double finalPrice = getPrice() * minimumNights;

        if (renter.getType() == RenterType.PERSON && renter.isLoyalCustomer()) {
            finalPrice *= 0.5;
        } else {
            finalPrice *= 1 - renter.getDiscountPercentage();
        }

        setRentDay(LocalDate.now());
        setReturnDeadline(getRentDay().plusDays(minimumNights));

        Invoice invoice = new Invoice(this, renter, deposit);
        invoice.setTotalAmount(finalPrice + deposit);
        return invoice;
    }
}
