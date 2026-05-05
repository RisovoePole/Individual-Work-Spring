package com.ScheduleGen.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class AudienceRoomtypeId implements Serializable {

    @Column(name = "room_type_id")
    private Integer roomTypeId;

    @Column(name = "audience_id")
    private Integer audienceId;
}

