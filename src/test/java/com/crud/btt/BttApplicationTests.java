package com.crud.btt;

import com.crud.btt.map.entity.WelfareFacilityEntity;
import com.crud.btt.map.entity.WelfareFacilityRepository;
import com.crud.btt.map.entity.WelfareFacilityRepositoryCustom;
import com.crud.btt.map.model.dto.WelfareFacilityDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BttApplicationTests {
	private final WelfareFacilityRepository welfareFacilityRepository;
	private final WelfareFacilityRepositoryCustom welfareFacilityRepositoryCustom;

	BttApplicationTests(WelfareFacilityRepository welfareFacilityRepository, WelfareFacilityRepositoryCustom welfareFacilityRepositoryCustom) {
		this.welfareFacilityRepository = welfareFacilityRepository;
		this.welfareFacilityRepositoryCustom = welfareFacilityRepositoryCustom;
	}

	@Test
	void contextLoads() {
		// List<WelfareFacilityDto> list = new ArrayList<>();

		// Page<WelfareFacilityEntity> welfareFacilityEntities = welfareFacilityRepositoryCustom.findAllBySearchCondition(pageable);
		// for (WelfareFacilityEntity entity : welfareFacilityEntities) {
        //     WelfareFacilityDto dto = WelfareFacilityDto.builder()
        //             .wfNo(entity.getWfNo())
        //             .wfName(entity.getWfName())
        //             .wfCat(entity.getWfCat())
        //             .address(entity.getAddress())
        //             .address2(entity.getAddress2())
        //             .phone(entity.getPhone())
        //             .latitude(entity.getLatitude())
        //             .logitude(entity.getLogitude())
        //             .build();
        //     list.add(dto);
        // }
		// System.out.println(list);

	}

}
