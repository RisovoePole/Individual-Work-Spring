package com.ScheduleGen.model.services;

import com.ScheduleGen.api.dtos.CreateRequestDTOs.CreateDisciplineDTO;
import com.ScheduleGen.api.dtos.PatchRequestDTOs.PatchDisciplineDTO;
import com.ScheduleGen.api.dtos.ResponseDTOs.DisciplineDTO;
import com.ScheduleGen.api.dtos.UpdateRequestDTOs.UpdateDisciplineDTO;
import com.ScheduleGen.application.mappers.DisciplineMapper;
import com.ScheduleGen.exceptions.ConflictException;
import com.ScheduleGen.exceptions.NotFoundException;
import com.ScheduleGen.model.entities.Discipline;
import com.ScheduleGen.persistence.entities.DisciplineEntity;
import com.ScheduleGen.infrastructure.persistence.mappers.DisciplineEntityMapper;
import com.ScheduleGen.persistence.repos.DisciplineRepo;
import com.ScheduleGen.persistence.repos.SpecializationRepo;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DisciplineService {
    private final DisciplineRepo disciplineRepo;
    private final DisciplineMapper dtoMapper;
    private final DisciplineEntityMapper entityMapper;
    private final SpecializationRepo specRepo;



    public DisciplineDTO create(CreateDisciplineDTO createDto) {
        // CreateDisciplineDTO → DTO
        DisciplineDTO dto = dtoMapper.CreateRequestToDTO(createDto);

        // DTO → Domain
        Discipline domain = dtoMapper.DTOtoDomain(dto);

        // Domain → Entity
        DisciplineEntity entity = entityMapper.DomainToEntity(domain);

        DisciplineEntity savedEntity;
        //  Сохраняем в БД
        try {
            savedEntity = disciplineRepo.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new ConflictException("Discipline with the same data already exist");
        }

        //  Entity → Domain
        Discipline savedDomain = entityMapper.EntityToDomain(savedEntity);

        //  Domain → DTO
        return dtoMapper.DomainToDTO(savedDomain);
    }

    public DisciplineDTO patch(PatchDisciplineDTO updateDto){
        DisciplineDTO dto = dtoMapper.PatchRequestToDTO(updateDto);
        Discipline domain = dtoMapper.DTOtoDomain(dto);
        DisciplineEntity entity = disciplineRepo.findById(domain.getId())
                .orElseThrow(() -> new NotFoundException("Discipline with such id not found"));

        if(domain.getName() != null)
            entity.setDisciplineName(domain.getName());
        if(domain.getStudySemester() != null)
            entity.setStudySemester(domain.getStudySemester());
        if(domain.getCredits() != null)
            entity.setCredits(domain.getCredits());
        if(domain.getSpecializationId() != null)
            entity.setSpecialization(
                    specRepo.findById(domain.getSpecializationId())
                            .orElseThrow(() -> new NotFoundException("Specialization not found")));
        DisciplineEntity savedEntity = disciplineRepo.save(entity);

        Discipline savedDiscipline = entityMapper.EntityToDomain(savedEntity);
        return dtoMapper.DomainToDTO(savedDiscipline);
    }

    public DisciplineDTO update(UpdateDisciplineDTO discipline){
        disciplineRepo.findById(discipline.id)
                .orElseThrow(() -> new NotFoundException("Discipline with such id not found"));

        DisciplineEntity savedEntity = new DisciplineEntity(
                discipline.id,
                discipline.name,
                discipline.studySemester,
                null,
                discipline.credits,
                specRepo.findById(discipline.specializationId)
                        .orElseThrow(() -> new NotFoundException("Specialization not found")),
                null,
                null,
                null
                );

        return dtoMapper.DomainToDTO(
                entityMapper.EntityToDomain(
                        disciplineRepo.save(savedEntity)));
    }

    public DisciplineDTO getDiscipline(Integer id){
        DisciplineEntity disciplineEntity = disciplineRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("discipline not found"));

        return dtoMapper.DomainToDTO(entityMapper.EntityToDomain(disciplineEntity));
    }

    public List<DisciplineDTO> getAll() {
        return disciplineRepo.findAll().stream()
                .map(entityMapper::EntityToDomain)
                .map(dtoMapper::DomainToDTO)
                .toList();
    }

    public DisciplineDTO deleteById(Integer id){
        DisciplineEntity discipline = disciplineRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Discipline not found"));
        disciplineRepo.delete(discipline);
        return dtoMapper.DomainToDTO(
                entityMapper.EntityToDomain(discipline));
    }
}
