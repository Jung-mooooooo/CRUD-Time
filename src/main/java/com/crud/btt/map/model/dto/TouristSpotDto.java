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

    private long ts_no;
    private String ts_name;
    private String ts_cat;
    private String address;
    private String address2;
    private String phone;
    private String latitude;
    private String logitude;

}
