package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "group_elder_student")
public class GroupElderStudent {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private GroupElderStudentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentsGroupId")
    @JoinColumn(name = "students_group_id", referencedColumnName = "students_group_id")
    private StudentsGroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private StudentEntity student;
}
