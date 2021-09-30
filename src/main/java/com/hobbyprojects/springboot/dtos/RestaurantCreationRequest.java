package com.hobbyprojects.springboot.dtos;

import com.hobbyprojects.springboot.entities.Category;
import com.hobbyprojects.springboot.entities.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantCreationRequest {
    private String name;
    private String email;
    private String contactNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<DayOfWeek> holidays;
    private String category;

    public Restaurant toRestaurantEntity() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setEmail(email);
        restaurant.setContactNumber(contactNumber);
        restaurant.setCategory(Category.valueOf(category));
        return restaurant;
    }
}
