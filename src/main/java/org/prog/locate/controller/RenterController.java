package org.prog.locate.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.prog.locate.entity.Renter;
import org.prog.locate.service.RenterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/renters")
@RequiredArgsConstructor
public class RenterController {

  private final RenterService renterService;

  @GetMapping
  public ResponseEntity<List<Renter>> getAllRenters() {
    return ResponseEntity.ok(renterService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Renter> getRenter(@PathVariable Long id) {
    return ResponseEntity.ok(renterService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Renter> createRenter(@RequestBody Renter renter) {
    var saved = renterService.save(renter);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }
}
