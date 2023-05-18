package com.crud.btt.map.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TouristSpotDto {

    private Long tsNo;
    private String tsName;
    private String tsCat;
    private String address;
    private String address2;
    private String phone;
    private String latitude;
    private String longitude;

}
