package org.prog.locate.entity;

import jakarta.persistence.Entity;

@Entity
public class Phone extends Article {

    private boolean screenOk;
    private boolean cameraOk;
    private double deposit;

    @Override
    public Invoice rent(Renter renter) {
        return new Invoice(this, renter, deposit);
    }
}