package com.ScheduleGen.infrastructure.persistence.repos;

import com.ScheduleGen.infrastructure.persistence.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
}
