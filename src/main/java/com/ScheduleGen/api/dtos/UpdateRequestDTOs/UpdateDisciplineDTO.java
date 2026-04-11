package com.ScheduleGen.api.dtos.UpdateRequestDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UpdateDisciplineDTO {
    @NotNull
    @Positive
    public Integer id;

    @NotBlank
    @Size(max = 40)
    public String name;

    @NotNull
    @Positive
    public Integer studySemester;
    @NotNull
    @Positive
    public Float credits;
    @NotNull
    @Positive
    public Integer specializationId;
}
