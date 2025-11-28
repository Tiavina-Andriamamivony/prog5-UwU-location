package org.prog.locate.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import jakarta.persistence.Column;

@Entity
public class Money extends Article {

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDate repaymentDate;

    @Column(nullable = false)
    private double interestRate = 0.0;

    @Override
    public Invoice rent(Renter renter) {
        double total = amount + (amount * interestRate);
        return new Invoice(this, renter, total);
    }
}
