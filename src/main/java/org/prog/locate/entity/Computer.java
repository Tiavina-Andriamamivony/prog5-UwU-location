package org.prog.locate.entity;

import jakarta.persistence.Entity;

@Entity
public class Computer extends Article {

    private boolean screenOk;
    private boolean keyboardOk;
    private double deposit;

    @Override
    public Invoice rent(Renter renter) {
        return new Invoice(this, renter, deposit);
    }
}
