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
@Table(name = "faculty")
public class FacultyEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;

    @Column(name = "faculty_name", unique = true)
    private String facultyName;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    private List<SpecializationEntity> specializations = new ArrayList<>();
}

