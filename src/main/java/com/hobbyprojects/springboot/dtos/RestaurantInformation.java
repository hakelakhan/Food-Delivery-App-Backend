package com.hobbyprojects.springboot.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantInformation {
    String name;
    double rating;
    String picture;
    String category;
    int averageCostPerPerson;
}
