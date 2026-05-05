package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.SpecializationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepo extends JpaRepository<SpecializationEntity, Integer> {
}
