package com.ScheduleGen.infrastructure.persistence.entities;

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
@Table(name = "schedule_generation")
public class ScheduleGenerationEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_generation_id")
    private Integer scheduleGenerationId;

    @Column(name = "created_at")
    private LocalTime createdAt;

    @OneToMany(mappedBy = "scheduleGeneration", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ScheduleEntity> schedules = new ArrayList<>();
}

