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
@Table(name = "sound_systems")
public class SoundSystem extends RentableItem {
    @Column(name = "power_watts")
    private Integer powerWatts;

    @Column(name = "number_of_speakers")
    private Integer numberOfSpeakers;

    @Column(name = "bluetooth")
    private Boolean bluetooth;
}
