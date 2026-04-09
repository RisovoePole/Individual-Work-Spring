package com.ScheduleGen.infrastructure.persistence.repos;

import com.ScheduleGen.infrastructure.persistence.entities.PairTimeBordersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairTimeBordersRepo extends JpaRepository<PairTimeBordersEntity, Integer> {
}
