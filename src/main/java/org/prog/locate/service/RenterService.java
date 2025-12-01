package org.prog.locate.service;

import org.prog.locate.entity.Renter;

import java.util.List;

public interface RenterService {
    List<Renter> findAll();
    Renter findById(Long id);
    Renter save(Renter renter);
}
