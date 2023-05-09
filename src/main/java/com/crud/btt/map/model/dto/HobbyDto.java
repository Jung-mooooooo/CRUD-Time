package com.crud.btt.map.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HobbyDto {

    private long hobbyNo;
    private String hobbyName;
    private String hobbyCat;
    private String address;
    private String address2;
    private String phone;
    private String latitude;
    private String logitude;

}
