package com.ScheduleGen.domain.entities;

import com.ScheduleGen.infrastructure.persistence.entities.DisciplineEntity;
import lombok.AllArgsConstructor;

public class Discipline {
    private Integer id;
    private String name;
    private Integer studySemester;
    private Float credits;

    public Discipline(Integer id, String name, Integer studySemester, Float credits){
        //if(id)
    }
}
