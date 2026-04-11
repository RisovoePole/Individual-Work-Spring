package com.ScheduleGen.api.dtos.ResponseDTOs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DisciplineDTO {
    public Integer id;
    public String name;
    public Integer studySemester;
    public Float credits;
    public Integer specializationId;
}
