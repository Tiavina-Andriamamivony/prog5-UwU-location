package org.prog.locate.service;

import java.util.List;
import org.prog.locate.entity.RentableItem;
import org.prog.locate.entity.RentableItemType;

public interface ItemService {
  List<RentableItem> findAll();

  List<RentableItem> findByAvailable(boolean available);

  List<RentableItem> findByTypeAndAvailable(RentableItemType type, boolean available);

  RentableItem findById(Long id);

  RentableItem save(RentableItem item);
}
