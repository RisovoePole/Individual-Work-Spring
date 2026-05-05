package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.AudienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudienceRepo extends JpaRepository<AudienceEntity, Integer> {
}
