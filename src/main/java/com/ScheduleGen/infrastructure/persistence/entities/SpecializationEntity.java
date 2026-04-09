package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "specialization")
public class SpecializationEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private Integer specId;

    @Column(name = "spec_name")
    private String specName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    private FacultyEntity faculty;

    @Column(name = "years_of_study")
    private Integer yearsOfStudy;

    @OneToMany(mappedBy = "specialization", fetch = FetchType.LAZY)
    private List<DisciplineEntity> disciplines = new ArrayList<>();

    @OneToMany(mappedBy = "specialization", fetch = FetchType.LAZY)
    private List<StudentsGroupEntity> studentsGroups = new ArrayList<>();
}

