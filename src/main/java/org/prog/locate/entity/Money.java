package org.prog.locate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import java.time.LocalDate;

@Entity
public class Money extends Article {
    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDate repaymentDate;

    @Column(nullable = false)
    private double interestRate = 0.0;

    public Money() {
        setType(ArticleType.MONEY);
    }

    @Override
    public Invoice rent(Renter renter) {
        double finalPrice = amount + (amount * interestRate);

        if (renter.getType() == RenterType.PERSON && renter.isLoyalCustomer()) {
            finalPrice *= 0.2;
        } else {
            finalPrice *= 1 - renter.getDiscountPercentage();
        }
        setRentDay(LocalDate.now());
        setReturnDeadline(getRentDay().plusDays(1));

        Invoice invoice = new Invoice(this, renter, 0);
        invoice.setTotalAmount(finalPrice);
        return invoice;
    }
}
