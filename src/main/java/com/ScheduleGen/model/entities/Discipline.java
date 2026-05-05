package com.ScheduleGen.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {
    private Integer id;
    @Setter
    private String name;
    @Setter
    private Integer studySemester;
    @Setter
    private Float credits;
    @Setter
    private Integer specializationId;
}
