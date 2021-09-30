package com.hobbyprojects.springboot.services;

import com.hobbyprojects.springboot.dtos.AllRestaurantInformation;
import com.hobbyprojects.springboot.dtos.RestaurantCreationRequest;
import com.hobbyprojects.springboot.dtos.RestaurantInformation;
import com.hobbyprojects.springboot.entities.Restaurant;
import com.hobbyprojects.springboot.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return restaurantOptional.map(Restaurant::toRestaurantInformation).orElse(null);
    }

    public AllRestaurantInformation getAllRestaurantInformation() {
        List<RestaurantInformation> allRestaurantInfo = restaurantRepository.findAll().stream().map(Restaurant::toRestaurantInformation).collect(Collectors.toList());
        AllRestaurantInformation allRestaurantInformation = new AllRestaurantInformation();
        allRestaurantInformation.setRestaurants(allRestaurantInfo);
        return allRestaurantInformation;

    }

    public void createRestaurant(RestaurantCreationRequest restaurantCreationRequest) {
        Restaurant restaurant = restaurantCreationRequest.toRestaurantEntity();
        restaurantRepository.save(restaurant);
    }

    public AllRestaurantInformation getRestaurantsByCategory(String category) {
        List<RestaurantInformation> allRestaurantInfo = restaurantRepository.findAll().stream().filter( restaurant -> category.equals(String.valueOf(restaurant.getCategory()))).map(Restaurant::toRestaurantInformation).collect(Collectors.toList());
        AllRestaurantInformation allRestaurantInformation = new AllRestaurantInformation();
        allRestaurantInformation.setRestaurants(allRestaurantInfo);
        return allRestaurantInformation;
    }

    public void deleteRestaurantById(long id) {
        restaurantRepository.deleteById(id);

    }
}
