package org.prog.locate.controller;

import lombok.RequiredArgsConstructor;
import org.prog.locate.entity.Invoice;
import org.prog.locate.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/articles/{articleId}/renters/{renterId}")
    public ResponseEntity<Invoice> rentArticle(
            @PathVariable Long articleId,
            @PathVariable Long renterId
    ) {
        Invoice invoice = rentalService.rentArticle(articleId, renterId);
        return ResponseEntity.ok(invoice);
    }
}
