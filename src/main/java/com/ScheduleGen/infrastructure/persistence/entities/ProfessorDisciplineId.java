package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ProfessorDisciplineId implements Serializable {

    @Column(name = "professor_id")
    private Integer professorId;

    @Column(name = "discipline_id")
    private Integer disciplineId;
}
