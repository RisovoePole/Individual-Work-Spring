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
@Table(name = "students_group")
public class StudentsGroupEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "students_group_id")
    private Integer studentsGroupId;

    @Column(name = "group_name", unique = true)
    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_inspector", referencedColumnName = "professor_id")
    private ProfessorEntity professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spec_id", referencedColumnName = "spec_id")
    private SpecializationEntity specialization;

    @OneToMany(mappedBy = "studentsGroup", fetch = FetchType.LAZY)
    private List<StudentEntity> students = new ArrayList<>();

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<GroupElderStudent> groupElderStudents = new ArrayList<>();

    @OneToMany(mappedBy = "studentsGroup", fetch = FetchType.LAZY)
    private List<ScheduleEntity> schedules = new ArrayList<>();

}

