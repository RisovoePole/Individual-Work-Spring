package com.ScheduleGen.api.dtos.PatchRequestDTOs;

import com.ScheduleGen.api.CustomValidations.NotSpacesOnly;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PatchDisciplineDTO {
    @NotNull @Positive
    public Integer id;

    @NotSpacesOnly
    @Size(max = 40)
    public String name;
    @Positive
    public Integer studySemester;
    @Positive
    public Float credits;
    @Positive
    public Integer specializationId;
}
