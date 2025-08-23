package com.myplantdiary.enterprise.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(schema = "PlantDB")
public class Specimen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int specimenId;
    @Column(nullable = false)
    private String latitude;
    @Column(nullable = false)
    private String longitude;
    @Column(name = "plant ID", nullable = false)
    private int plantId;

    private String description;

}
