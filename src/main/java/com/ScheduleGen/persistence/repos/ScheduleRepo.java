package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<ScheduleEntity, Integer> {
}
