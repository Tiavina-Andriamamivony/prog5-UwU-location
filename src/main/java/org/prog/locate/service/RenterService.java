package org.prog.locate.service;

import java.util.List;
import org.prog.locate.entity.Renter;

public interface RenterService {
  List<Renter> findAll();

  Renter findById(Long id);

  Renter save(Renter renter);
}
