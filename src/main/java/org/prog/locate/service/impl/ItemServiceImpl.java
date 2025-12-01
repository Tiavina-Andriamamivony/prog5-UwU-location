package org.prog.locate.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.prog.locate.entity.RentableItem;
import org.prog.locate.entity.RentableItemType;
import org.prog.locate.exception.ResourceNotFoundException;
import org.prog.locate.repository.RentableItemRepository;
import org.prog.locate.service.ItemService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final RentableItemRepository itemRepository;

  @Override
  public List<RentableItem> findAll() {
    return itemRepository.findAll();
  }

  @Override
  public List<RentableItem> findByAvailable(boolean available) {
    return itemRepository.findByAvailable(available);
  }

  @Override
  public List<RentableItem> findByTypeAndAvailable(RentableItemType type, boolean available) {
    return itemRepository.findByTypeAndAvailable(type, available);
  }

  @Override
  public RentableItem findById(Long id) {

    return itemRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
  }

  @Override
  public RentableItem save(RentableItem item) {
    return itemRepository.save(item);
  }
}
