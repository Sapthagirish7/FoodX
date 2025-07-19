package com.sapthagirish.foodx.utils;

import com.sapthagirish.foodx.model.Restaurant;
import com.sapthagirish.foodx.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidationUtils {
    final RestaurantRepository restaurantRespository;

    @Autowired
    public ValidationUtils(RestaurantRepository restaurantRespository) {
        this.restaurantRespository = restaurantRespository;
    }

    public boolean validateRestaurantId(int id){

        Optional<Restaurant> restaurantOptional = restaurantRespository.findById(id);
        return restaurantOptional.isPresent();
    }

}
