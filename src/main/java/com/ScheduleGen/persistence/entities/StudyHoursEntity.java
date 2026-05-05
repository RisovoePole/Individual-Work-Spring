package com.ScheduleGen.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "study_hours")
public class StudyHoursEntity {

    @Id
    @EqualsAndHashCode.Include
    private Integer disciplineId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "discipline_id", referencedColumnName = "discipline_id")
    private DisciplineEntity discipline;

    @Column(name = "contact_study_hours")
    private Double contactStudyHours;

    @Column(name = "independent_study_hours")
    private Double independentStudyHours;

    @Column(name = "course_hours")
    private Double courseHours;

    @Column(name = "seminar_hours")
    private Double seminarHours;

    @Column(name = "laboratories_hours")
    private Double laboratoriesHours;
}

