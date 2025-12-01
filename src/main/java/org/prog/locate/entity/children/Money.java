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
@Table(name = "moneys")
public class Money extends RentableItem {
    @Column(name = "currency")
    private String currency;

    @Column(name = "minimum_lease_amount")
    private Double minimumLeaseAmount;

    @Column(name = "repayment_delay_days")
    private Integer repaymentDelayDays;

}
