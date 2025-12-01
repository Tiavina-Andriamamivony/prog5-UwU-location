package org.prog.locate.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.prog.locate.entity.RentableItem;
import org.prog.locate.entity.RentableItemType;
import org.prog.locate.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @GetMapping
  public ResponseEntity<List<RentableItem>> getAllItems() {
    return ResponseEntity.ok(itemService.findAll());
  }

  @GetMapping("/available")
  public ResponseEntity<List<RentableItem>> getAvailableItems() {
    return ResponseEntity.ok(itemService.findByAvailable(true));
  }

  @GetMapping("/type/{type}")
  public ResponseEntity<List<RentableItem>> getItemsByType(@PathVariable RentableItemType type) {
    return ResponseEntity.ok(itemService.findByTypeAndAvailable(type, true));
  }

  @PutMapping("/{id}/availability")
  public ResponseEntity<RentableItem> updateAvailability(
      @PathVariable Long id, @RequestParam boolean available) {

    var item = itemService.findById(id);

    item.setAvailable(available);
    return ResponseEntity.ok(itemService.save(item));
  }
}
