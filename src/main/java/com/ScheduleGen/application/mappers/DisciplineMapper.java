package com.ScheduleGen.application.mappers;

import com.ScheduleGen.api.dtos.CreateRequestDTOs.CreateDisciplineDTO;
import com.ScheduleGen.api.dtos.PatchRequestDTOs.PatchDisciplineDTO;
import com.ScheduleGen.api.dtos.ResponseDTOs.DisciplineDTO;
import com.ScheduleGen.api.dtos.UpdateRequestDTOs.UpdateDisciplineDTO;
import com.ScheduleGen.domain.entities.Discipline;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class DisciplineMapper {
    public Discipline DTOtoDomain(DisciplineDTO disciplineDTO) {
        return new Discipline(disciplineDTO.id,
                disciplineDTO.name,
                disciplineDTO.studySemester,
                disciplineDTO.credits,
                disciplineDTO.specializationId);
    }

    public DisciplineDTO DomainToDTO(Discipline discipline) {
        return new DisciplineDTO(discipline.getId(),
                discipline.getName(),
                discipline.getStudySemester(),
                discipline.getCredits(),
                discipline.getSpecializationId());
    }

    public DisciplineDTO UpdateRequestToDTO(UpdateDisciplineDTO discipline){
        return new DisciplineDTO(discipline.id,
                discipline.name,
                discipline.studySemester,
                discipline.credits,
                discipline.specializationId);
    }

    public DisciplineDTO CreateRequestToDTO(CreateDisciplineDTO discipline){
        return new DisciplineDTO(null,
                discipline.name,
                discipline.studySemester,
                discipline.credits,
                discipline.specializationId);
    }
    public DisciplineDTO PatchRequestToDTO(PatchDisciplineDTO discipline){
        return new DisciplineDTO(discipline.id,
                discipline.name,
                discipline.studySemester,
                discipline.credits,
                discipline.specializationId);
    }
}
