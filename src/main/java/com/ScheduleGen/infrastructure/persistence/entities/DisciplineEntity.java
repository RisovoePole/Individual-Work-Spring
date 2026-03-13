package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "discipline")
@ToString
public class DisciplineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id")
    private Long id;

    @Column(name = "discipline_name")
    private String name;

    @Column(name = "required_room_type")
    private Integer requiredRoomType;

    @Column(name = "credits")
    private Float credits;

    @ManyToOne
    @JoinColumn(name = "spec_id")
    private SpecializationEntity specialization;

    @Column(name = "contact_study_hours")
    private Float contactStudyHours;

    @Column(name = "independent_study_hours")
    private Float independentStudyHours;

    @Column(name = "course_hours")
    private Float courseHours;

    @Column(name = "seminar_hours")
    private Float seminarHours;

    @Column(name = "laboratories_hours")
    private Float laboratoriesHours;


}
