package com.ScheduleGen.persistence.entities;

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
@Table(name = "professor")
public class ProfessorEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Integer professorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<ProfessorDiscipline> professorDisciplines = new ArrayList<>();

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<StudentsGroupEntity> supervisedGroups = new ArrayList<>();

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private List<ScheduleEntity> schedules = new ArrayList<>();
}

