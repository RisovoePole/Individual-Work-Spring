package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.ScheduleGenerationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleGenerationRepo extends JpaRepository<ScheduleGenerationEntity, Integer> {
}
