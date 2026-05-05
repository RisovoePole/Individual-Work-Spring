package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.StudyHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyHoursRepo extends JpaRepository<StudyHoursEntity, Integer> {
}
