package com.elijah.vacationtourproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourismInfoDto {

    private String name;
    private String description;
    private String image;
    private Integer price;
    private Integer people;
    private Integer stars;
    private String location;
}
