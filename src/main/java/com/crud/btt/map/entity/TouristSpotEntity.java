package com.crud.btt.map.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TOURIST_SPOT")
@Entity
public class TouristSpotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TS_NO")
    private Long tsNo;
    @Column(name = "TS_NAME")
    private String tsName;
    @Column(name = "TS_CAT")
    private String tsCat;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LONGITUDE")
    private String longitude;
}
