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
@Table(name="HOBBY")
@Entity
public class HobbyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hobby_gen")
    @SequenceGenerator(
            name = "seq_hobby_gen",
            sequenceName = "SEQ_HOBBY",
            initialValue=1, //시작값
            allocationSize=1 //메모리를 통해 할당할 범위 사이즈
    )
    @Column(name = "HOBBY_NO")
    private Long hobbyNo;
    @Column(name = "HOBBY_NAME")
    private String hobbyName;
    @Column(name = "HOBBY_CAT")
    private String hobbyCat;
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
