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
@ToString(exclude = {"scheduleEntities","professorDisciplines"})
@Entity
@Table(name = "discipline")
public class DisciplineEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id")
    private Integer disciplineId;

    @Column(name = "discipline_name")
    private String disciplineName;

    @Column(name = "study_semester")
    private Integer studySemester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "required_room_type", referencedColumnName = "room_type_id")
    private RoomTypeEntity requiredRoomType;

    @Column(name = "credits")
    private Float credits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spec_id", referencedColumnName = "spec_id")
    private SpecializationEntity specialization;

    @OneToOne(mappedBy = "discipline", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StudyHoursEntity studyHours;

    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    private List<ProfessorDiscipline> professorDisciplines = new ArrayList<>();

    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY)
    private List<ScheduleEntity> scheduleEntities = new ArrayList<>();
}

