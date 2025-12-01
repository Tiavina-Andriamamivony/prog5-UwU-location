package org.prog.locate.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prog.locate.entity.Renter;
import org.prog.locate.exception.ResourceNotFoundException;
import org.prog.locate.repository.RenterRepository;
import org.prog.locate.service.RenterService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RenterServiceImpl implements RenterService {
  private final RenterRepository renterRepository;

  @Override
  public List<Renter> findAll() {
    return renterRepository.findAll();
  }

  @Override
  public Renter findById(Long id) {
    return renterRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Renter not found"));
  }

  @Override
  public Renter save(Renter renter) {
    return renterRepository.save(renter);
  }
}
