package org.prog.locate.entity;

import jakarta.persistence.Entity;

@Entity
public class House extends Article {

    private String address;
    private int minimumNights = 1;
    private double deposit;
    private String rules;

    @Override
    public Invoice rent(Renter renter) {
        return new Invoice(this, renter, deposit);
    }
}
