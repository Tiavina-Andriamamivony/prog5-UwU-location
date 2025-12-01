package org.prog.locate.entity.children;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Table(name = "mobile_phones")
public class MobilePhone extends RentableItem {
    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "ram_size_gb")
    private Integer ramSizeGb;

    @Column(name = "storage_size_gb")
    private Integer storageSizeGb;

}
