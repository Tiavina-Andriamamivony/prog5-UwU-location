package org.prog.locate.manager.model;

import lombok.Builder;
import org.prog.locate.entity.RentalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static org.prog.locate.entity.RentalType.CHURCH;
import static org.prog.locate.entity.RentalType.INDIVIDUAL;
import static org.prog.locate.entity.RentalType.ORGANIZATION;
import static org.prog.locate.entity.RentalType.SCHOOL;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Discount {
    private RentalType type;
    private double percentage;

    public static Discount church() {
        return Discount.builder()
                .type(CHURCH)
                .percentage(0.20)
                .build();
    }

    public static Discount organization() {
        return Discount.builder()
                .type(ORGANIZATION)
                .percentage(0.10)
                .build();
    }

    public static Discount individual() {
        return Discount.builder()
                .type(INDIVIDUAL)
                .percentage(0.0)
                .build();
    }

    public static Discount school() {
        return Discount.builder()
                .type(SCHOOL)
                .percentage(0.15)
                .build();
    }
}
