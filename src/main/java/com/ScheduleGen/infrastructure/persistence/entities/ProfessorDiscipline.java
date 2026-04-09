package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "professor_discipline")
public class ProfessorDiscipline {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ProfessorDisciplineId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("professorId")
    @JoinColumn(name = "professor_id", referencedColumnName = "professor_id")
    private ProfessorEntity professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("disciplineId")
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id")
    private DisciplineEntity discipline;
}
