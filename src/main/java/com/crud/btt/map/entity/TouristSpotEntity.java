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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ts_gen")
    @SequenceGenerator(
            name = "seq_ts_gen",
            sequenceName = "SEQ_TOURIST_SPOT",
            initialValue=1, //시작값
            allocationSize=1 //메모리를 통해 할당할 범위 사이즈
    )
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
