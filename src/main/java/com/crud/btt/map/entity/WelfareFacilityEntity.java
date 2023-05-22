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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_wf_gen")
    @SequenceGenerator(
            name="seq_wf_gen", //시퀀스 제너레이터 이름
            sequenceName="SEQ_WELFARE_FACILITY", //시퀀스 이름
            initialValue=1, //시작값
            allocationSize=1 //메모리를 통해 할당할 범위 사이즈
    )
    @Column(name = "WF_NO")
    private Long wfNo;
    @Column(name = "WF_NAME")
    private String wfName;
    @Column(name = "WF_CAT")
    private String wfCat;
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
