package org.prog.locate.repository;

import org.prog.locate.entity.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository<Renter, Long> {
}
