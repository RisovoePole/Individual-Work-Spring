package com.ScheduleGen.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pairtimeborders")
public class PairTimeBordersEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pair_number")
    private Integer pairNumber;

    @Column(name = "pair_start")
    private LocalTime pairStart;

    @Column(name = "pair_end")
    private LocalTime pairEnd;

    @OneToMany(mappedBy = "pairtimeborders", fetch = FetchType.LAZY)
    private List<TimeSlotEntity> timeSlots = new ArrayList<>();
}

