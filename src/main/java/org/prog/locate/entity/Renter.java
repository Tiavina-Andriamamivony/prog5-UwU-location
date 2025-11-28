package org.prog.locate.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "renters")
public class Renter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RenterType type;

    public enum RenterType {
        PERSON,
        COMPANY,
        CHURCH,
        ASSOCIATION
    }
}
