package org.prog.locate.entity;

import jakarta.persistence.Entity;

@Entity
public class Car extends Article {

    private boolean validLicense;
    private double deposit;

    @Override
    public Invoice rent(Renter renter) {
        if (!validLicense) {
            throw new IllegalStateException("Invalid driver's license.");
        }
        return new Invoice(this, renter, deposit);
    }
}
