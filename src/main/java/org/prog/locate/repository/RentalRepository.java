package org.prog.locate.repository;

import org.prog.locate.entity.Rental;
import org.prog.locate.entity.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByStatus(RentalStatus status);
    List<Rental> findByItemIdAndStatus(Long itemId, RentalStatus status);
}