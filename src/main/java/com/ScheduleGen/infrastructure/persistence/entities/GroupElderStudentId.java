package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class GroupElderStudentId implements Serializable {

    @Column(name = "students_group_id")
    private Integer studentsGroupId;

    @Column(name = "student_id")
    private Integer studentId;
}



