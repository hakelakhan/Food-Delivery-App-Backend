package com.hobbyprojects.springboot.services;

import com.hobbyprojects.springboot.entities.Restaurant;
import com.hobbyprojects.springboot.repositories.RestaurantRepository;

public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    public RestaurantService() {
        this.restaurantRepository = new RestaurantRepository();
    }

    Restaurant getRestaurantDetails(int id) {
        return restaurantRepository.findRestaurantById(id);
    }
}
