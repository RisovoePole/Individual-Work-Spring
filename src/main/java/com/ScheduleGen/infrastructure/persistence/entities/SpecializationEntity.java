package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "specialization")
@ToString
public class SpecializationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private Long id;

    @Column(name = "spec_name")
    private String name;

    @Column(name = "faculty_id")
    private Integer facultyID;

    @Column(name = "years_of_study")
    private Integer yearsOfStudy;
}
