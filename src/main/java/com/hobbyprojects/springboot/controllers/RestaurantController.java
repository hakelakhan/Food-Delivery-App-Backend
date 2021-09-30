package com.hobbyprojects.springboot.controllers;

import com.hobbyprojects.springboot.dtos.AllRestaurantInformation;
import com.hobbyprojects.springboot.dtos.RestaurantCreationRequest;
import com.hobbyprojects.springboot.dtos.RestaurantInformation;
import com.hobbyprojects.springboot.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/getAll")
    AllRestaurantInformation getAllRestaurants() {
        return  restaurantService.getAllRestaurantInformation();
    }
    @GetMapping("/get/{id}")
    RestaurantInformation  getRestaurantInformation(@PathVariable int id) {
        return restaurantService.getRestaurantDetails(id);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createRestaurant(@RequestBody RestaurantCreationRequest restaurantCreationRequest) {
        restaurantService.createRestaurant(restaurantCreationRequest);
        return ResponseEntity.ok("Created Restaurant");

    }

    @GetMapping("/restaurant/search/{category}")
    public AllRestaurantInformation getRestaurantsByCategory(@PathVariable("category") String category) {
        return restaurantService.getRestaurantsByCategory(category);
    }

    @DeleteMapping("/restaurant/delete/{id}")
    public ResponseEntity<String> deleteRestaurantById(@PathVariable("id") int id) {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.ok("Restaurant deleted");
    }
}