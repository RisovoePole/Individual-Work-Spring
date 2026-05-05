package com.ScheduleGen.persistence.repos;

import com.ScheduleGen.persistence.entities.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepo extends JpaRepository<RoomTypeEntity, Integer> {
}
