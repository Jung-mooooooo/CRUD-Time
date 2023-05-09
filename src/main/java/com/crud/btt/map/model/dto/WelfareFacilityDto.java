package com.crud.btt.map.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WelfareFacilityDto {

    private long wfNo;
    private String wfName;
    private String wfCat;
    private String address;
    private String address2;
    private String phone;
    private String latitude;
    private String logitude;
}
