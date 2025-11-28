package org.prog.locate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(length = 500)
    private String description;

    private int stock;
    private double price;

    @Enumerated(EnumType.STRING)
    private ArticleType type;

    private boolean available = true;

    public abstract Invoice rent(Renter renter);
}
