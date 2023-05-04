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
@Table(name="WELFARE_FACILITY")
@Entity
public class WelfareFacilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WF_NO")
    private long wf_no;
    @Column(name = "WF_NAME")
    private String wf_name;
    @Column(name = "WF_CAT")
    private String wf_cat;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LOGITUDE")
    private String logitude;
}
