package com.ScheduleGen.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "audience_roomtype")
public class AudienceRoomtype {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private AudienceRoomtypeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roomTypeId")
    @JoinColumn(name = "room_type_id", referencedColumnName = "room_type_id")
    private RoomTypeEntity roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("audienceId")
    @JoinColumn(name = "audience_id", referencedColumnName = "audience_id")
    private AudienceEntity audience;
}

