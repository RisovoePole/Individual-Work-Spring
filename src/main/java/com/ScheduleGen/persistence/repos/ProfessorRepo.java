package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<ProfessorEntity, Integer> {
}
