package com.hobbyprojects.springboot.controllers;

import com.hobbyprojects.springboot.dtos.AllRestaurantInformation;
import com.hobbyprojects.springboot.dtos.RestaurantInformation;
import com.hobbyprojects.springboot.entities.Restaurant;
import com.hobbyprojects.springboot.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    AllRestaurantInformation getAllRestaurants() {
        return  restaurantService.getAllRestaurantInformation();
    }
    @GetMapping("restaurants/{id}")
    RestaurantInformation getRestaurantInformation(@PathVariable int id) {
        return restaurantService.getRestaurantDetails(id);
    }


}
