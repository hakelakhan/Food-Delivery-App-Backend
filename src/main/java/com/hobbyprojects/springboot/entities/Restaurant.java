package com.hobbyprojects.springboot.entities;


import com.hobbyprojects.springboot.dtos.RestaurantInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String contactNumber;
    private Category category;
    private double rating;
    private int averageCost;
    private String profilePicture;

    public RestaurantInformation toRestaurantInformation() {
        RestaurantInformation restaurantInformation = new RestaurantInformation();
        restaurantInformation.setName(this.getName());
        restaurantInformation.setCategory(this.getCategory().toString());
        restaurantInformation.setPicture(this.getProfilePicture());
        restaurantInformation.setRating(this.getRating());
        restaurantInformation.setAverageCostPerPerson(this.getAverageCost());
        return restaurantInformation;
    }

}
