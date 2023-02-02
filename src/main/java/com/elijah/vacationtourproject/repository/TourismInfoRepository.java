package com.elijah.vacationtourproject.repository;

import com.elijah.vacationtourproject.model.tourist.TouristInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourismInfoRepository extends JpaRepository<TouristInfo,Long> {
}
