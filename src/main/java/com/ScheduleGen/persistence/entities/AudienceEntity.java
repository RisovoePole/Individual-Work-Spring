package com.ScheduleGen.persistence.entities;

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
@Table(name = "audience")
public class AudienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audience_id")
    @EqualsAndHashCode.Include
    private Integer audienceId;

    @Column(name = "room_name", unique = true)
    private String roomName;

    @Column(name = "university_building")
    private Integer universityBuilding;

    @Column(name = "amount_of_seats")
    private Integer amountOfSeats;

    @OneToMany(mappedBy = "audience", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AudienceRoomtype> audienceRoomtypes = new ArrayList<>();

    @OneToMany(mappedBy = "audience", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ScheduleEntity> scheduleEntities = new ArrayList<>();

}
