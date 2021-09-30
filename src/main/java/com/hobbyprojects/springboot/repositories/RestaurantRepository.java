package com.hobbyprojects.springboot.repositories;

import com.hobbyprojects.springboot.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
