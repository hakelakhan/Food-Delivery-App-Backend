package com.hobbyprojects.springboot.services;

import com.hobbyprojects.springboot.dtos.AllRestaurantInformation;
import com.hobbyprojects.springboot.dtos.RestaurantInformation;
import com.hobbyprojects.springboot.entities.Restaurant;
import com.hobbyprojects.springboot.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;


    public RestaurantInformation getRestaurantDetails(long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if(restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            RestaurantInformation restaurantInformation = new RestaurantInformation();
            restaurantInformation.setName(restaurant.getName());
            restaurantInformation.setCategory("Category");
            restaurantInformation.setPicture("Picture");
            restaurantInformation.setRating(5.0);
            restaurantInformation.setAverageCostPerPerson(200);
            return restaurantInformation;
        }
        else {
            return null;
        }
    }

    public AllRestaurantInformation getAllRestaurantInformation() {
        List<Restaurant> allRestaurants = restaurantRepository.findAll();
        AllRestaurantInformation allRestaurantInformation = new AllRestaurantInformation();
        allRestaurantInformation.setRestaurants(convertToRestaurantInformation(allRestaurants));
        return allRestaurantInformation;

    }

    private List<RestaurantInformation> convertToRestaurantInformation(List<Restaurant> allRestaurants) {
        allRestaurants.stream().map( restaurant -> {
            RestaurantInformation restaurantInformation = new RestaurantInformation();
            restaurantInformation.setName(restaurant.getName());
            return restaurantInformation;
        }).collect(Collectors.toList());
        return null;
    }


}
