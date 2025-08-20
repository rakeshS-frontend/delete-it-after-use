package com.myplantdiary.enterprise.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Specimen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int specimenId;
    @Column(name = "Plant Type", nullable = false)
    private String plantType;
    @Column(nullable = false)
    private String latitude;
    @Column(nullable = false)
    private String longitude;

}
