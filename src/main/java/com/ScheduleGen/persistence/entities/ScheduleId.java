package com.ScheduleGen.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ScheduleId implements Serializable {

    @Column(name = "schedule_generation_id")
    private Integer scheduleGenerationId;

    @Column(name = "week_pattern")
    private Integer weekPattern;

    @Column(name = "time_slot_id")
    private Integer timeSlotId;

}
