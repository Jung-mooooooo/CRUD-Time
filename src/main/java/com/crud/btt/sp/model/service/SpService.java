package com.crud.btt.sp.model.service;

import com.crud.btt.sp.entity.SpEntity;
import com.crud.btt.sp.entity.SpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SpService {

    private final SpRepository spRepository;


    public SpEntity userAuth(Long userCode, String pass) {
        return spRepository.findByUserCodeAndUserAuthIs(userCode, pass);
    }
}