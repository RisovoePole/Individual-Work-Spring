package com.ScheduleGen.infrastructure.persistence.repos;

import com.ScheduleGen.infrastructure.persistence.entities.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepo extends JpaRepository<TimeSlotEntity, Integer> {
}
