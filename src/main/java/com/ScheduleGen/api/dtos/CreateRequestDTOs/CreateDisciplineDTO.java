package com.ScheduleGen.api.dtos.CreateRequestDTOs;

import com.ScheduleGen.api.dtos.ResponseDTOs.DisciplineDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
public class CreateDisciplineDTO {

    @NotBlank @Size(max = 40)
    public String name;
    @NotNull @Positive
    public Integer studySemester;
    @NotNull @Positive
    public Float credits;
    @NotNull @Positive
    public Integer specializationId;

}
