package com.crud.btt.admin.entity;

import com.crud.btt.map.entity.TouristSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<EmotionEntity, Long> {
    int CountEmotion();
}
