package org.prog.locate.entity.children;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.prog.locate.entity.RentableItem;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@Table(name = "cars")
public class Car extends RentableItem {
  @Column(name = "brand")
  private String brand;

  @Column(name = "model")
  private String model;

  @Column(name = "year")
  private Integer year;

  @Column(name = "engine_capacity")
  private Double engineCapacity;

  @Column(name = "fuel_type")
  private String fuelType;
}
