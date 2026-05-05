package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<FacultyEntity, Integer> {
}
