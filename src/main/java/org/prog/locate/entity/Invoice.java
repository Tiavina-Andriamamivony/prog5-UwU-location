package org.prog.locate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Article article;

    @ManyToOne
    private Renter renter;

    private double totalAmount;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Invoice(Article article, Renter renter, double deposit) {
        this.article = article;
        this.renter = renter;
        this.totalAmount = article.getPrice() + deposit;
    }
}
