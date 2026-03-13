package com.ScheduleGen.infrastructure.persistence.repos;

import com.ScheduleGen.infrastructure.persistence.entities.DisciplineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepo extends JpaRepository<DisciplineEntity, Long> {
}
