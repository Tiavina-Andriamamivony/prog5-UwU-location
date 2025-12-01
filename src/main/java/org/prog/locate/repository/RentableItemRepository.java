package org.prog.locate.repository;

import java.util.List;
import org.prog.locate.entity.RentableItem;
import org.prog.locate.entity.RentableItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentableItemRepository extends JpaRepository<RentableItem, Long> {
  List<RentableItem> findByTypeAndAvailable(RentableItemType type, boolean available);

  List<RentableItem> findByAvailable(boolean available);
}
