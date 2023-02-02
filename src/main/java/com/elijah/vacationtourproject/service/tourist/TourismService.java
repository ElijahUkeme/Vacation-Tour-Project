package com.elijah.vacationtourproject.service.tourist;

import com.elijah.vacationtourproject.dto.TourismInfoDto;
import com.elijah.vacationtourproject.model.tourist.TouristInfo;
import com.elijah.vacationtourproject.repository.TourismInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourismService {

    @Autowired
    private TourismInfoRepository tourismInfoRepository;

    public TouristInfo addATouristCenter(TourismInfoDto tourismInfoDto, String touristCenterImage){
        TouristInfo touristInfo = new TouristInfo();
        touristInfo.setName(tourismInfoDto.getName());
        touristInfo.setDescription(tourismInfoDto.getDescription());
        touristInfo.setLocation(tourismInfoDto.getLocation());
        touristInfo.setImage(touristCenterImage);
        touristInfo.setPeople(tourismInfoDto.getPeople());
        touristInfo.setPrice(tourismInfoDto.getPrice());
        touristInfo.setStars(tourismInfoDto.getStars());
        return tourismInfoRepository.save(touristInfo);
    }
    public List<TouristInfo> getAllTouristCenter(){
        return tourismInfoRepository.findAll();
    }
}
