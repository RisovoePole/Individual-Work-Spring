package com.ScheduleGen.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roomtype")
public class RoomTypeEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private Integer roomTypeId;

    @Column(name = "room_type_name")
    private String roomTypeName;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AudienceRoomtype> audienceRoomtypes = new ArrayList<>();

    @OneToMany(mappedBy = "requiredRoomType", fetch = FetchType.LAZY)
    private List<DisciplineEntity> disciplines = new ArrayList<>();

}

