package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.DisciplineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepo extends JpaRepository<DisciplineEntity, Integer> {
}
