package com.ScheduleGen.infrastructure.persistence.repos;

import com.ScheduleGen.infrastructure.persistence.entities.StudentsGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsGroupRepo extends JpaRepository<StudentsGroupEntity, Integer> {
}
