package org.prog.locate.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.prog.locate.entity.Rental;
import org.prog.locate.service.RentalService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

  private final RentalService rentalService;

  @PostMapping
  public ResponseEntity<Rental> createRental(@RequestBody Map<String, Object> request) {

    var renterId = Long.valueOf(request.get("renterId").toString());
    var itemId = Long.valueOf(request.get("itemId").toString());
    var startDate = LocalDate.parse(request.get("startDate").toString());
    var endDate = LocalDate.parse(request.get("endDate").toString());

    var rental = rentalService.createRental(renterId, itemId, startDate, endDate);
    return ResponseEntity.status(HttpStatus.CREATED).body(rental);
  }

  @PostMapping("/create")
  public ResponseEntity<Rental> createRental(
      @RequestParam Long renterId,
      @RequestParam Long itemId,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

    var rental = rentalService.createRental(renterId, itemId, startDate, endDate);
    return ResponseEntity.status(HttpStatus.CREATED).body(rental);
  }

  @GetMapping("/active")
  public ResponseEntity<List<Rental>> getActiveRentals() {
    var rentals = rentalService.getActiveRentals();
    return ResponseEntity.ok(rentals);
  }

  @PutMapping("/{id}/cancel")
  public ResponseEntity<Rental> cancelRental(@PathVariable Long id) {
    var rental = rentalService.cancelRental(id);
    return ResponseEntity.ok(rental);
  }

  @GetMapping("/renter/{renterId}")
  public ResponseEntity<List<Rental>> getRentalsByRenter(@PathVariable Long renterId) {
    var rentals = rentalService.getRentalsByRenter(renterId);
    return ResponseEntity.ok(rentals);
  }
}
