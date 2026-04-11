package com.ScheduleGen.infrastructure.persistence.mappers;

import com.ScheduleGen.domain.businessExceptions.BadRequestException;
import com.ScheduleGen.domain.businessExceptions.NotFoundException;
import com.ScheduleGen.domain.entities.Discipline;
import com.ScheduleGen.infrastructure.persistence.entities.DisciplineEntity;
import com.ScheduleGen.infrastructure.persistence.repos.SpecializationRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

/*
* Автоматическое обнаружение: Классы с @Component автоматически находятся Spring Boot, если они лежат в пакетах, сканируемых приложением (обычно это пакет, где находится класс с @SpringBootApplication).
Стереотип: Это общий стереотип. Специализированные аннотации, такие как @Service (логика), @Repository (хранилище данных) и @Controller (представление), наследуют @Component и предоставляют дополнительный функционал.
Синглтон: По умолчанию создается один экземпляр бина (Singleton).
* */
@Component
@AllArgsConstructor
public class DisciplineEntityMapper {

    private SpecializationRepo specRepo;

    public DisciplineEntity DomainToEntity(Discipline discipline) {
        if (discipline.getSpecializationId() == null)
            throw new BadRequestException("While mapping domain to entity occur specialization id set as null");
        try {
            return new DisciplineEntity(discipline.getId(),
                    discipline.getName(),
                    discipline.getStudySemester(),
                    null,
                    discipline.getCredits(),
                    specRepo.findById(discipline.getSpecializationId()).get(),
                    null,
                    null,
                    null);
        } catch (NoSuchElementException ex) {
            throw new NotFoundException("While mapping domain to entity not found specialization for discipline " + discipline.getSpecializationId());
        }
    }

    public Discipline EntityToDomain(DisciplineEntity disciplineEntity){
        return new Discipline(disciplineEntity.getDisciplineId(),
                disciplineEntity.getDisciplineName(),
                disciplineEntity.getStudySemester(),
                disciplineEntity.getCredits(),
                disciplineEntity.getSpecialization().getSpecId());
    }

}
