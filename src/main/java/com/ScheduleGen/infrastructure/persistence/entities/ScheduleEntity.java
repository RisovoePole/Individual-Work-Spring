package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ScheduleId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("scheduleGenerationId")
    @JoinColumn(name = "schedule_generation_id", referencedColumnName = "schedule_generation_id")
    private ScheduleGenerationEntity scheduleGeneration;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("timeSlotId")
    @JoinColumn(name = "time_slot_id", referencedColumnName = "time_slot_id")
    private TimeSlotEntity timeSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_group_id", referencedColumnName = "students_group_id")
    private StudentsGroupEntity studentsGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audience_id", referencedColumnName = "audience_id")
    private AudienceEntity audience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id")
    private DisciplineEntity discipline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", referencedColumnName = "professor_id")
    private ProfessorEntity professor;

    // UNIQUE (schedule_generation_id, week_pattern, time_slot_id, discipline_id)
    // UNIQUE (schedule_generation_id, week_pattern, time_slot_id, professor_id)
    // UNIQUE (schedule_generation_id, week_pattern, time_slot_id, students_group_id)
    // — в БД; в JPA обычно не дублируют.
}

