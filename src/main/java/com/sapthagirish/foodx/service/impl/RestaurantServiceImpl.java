package com.sapthagirish.foodx.service.impl;

import com.sapthagirish.foodx.dto.request.MenuItemRequest;
import com.sapthagirish.foodx.dto.request.RestaurantRequest;
import com.sapthagirish.foodx.dto.response.RestaurantResponse;
import com.sapthagirish.foodx.exception.RestaurantNotFoundException;
import com.sapthagirish.foodx.model.MenuItem;
import com.sapthagirish.foodx.model.Restaurant;
import com.sapthagirish.foodx.repository.RestaurantRepository;
import com.sapthagirish.foodx.service.RestaurantService;
import com.sapthagirish.foodx.utils.ValidationUtils;
import com.sapthagirish.foodx.transformer.MenuItemTransformer;
import com.sapthagirish.foodx.transformer.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    final RestaurantRepository restaurantRespository;
    final ValidationUtils validationUtils;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRespository, ValidationUtils validationUtils) {
        this.restaurantRespository = restaurantRespository;
        this.validationUtils = validationUtils;
    }


    @Override
    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        // dto -> model
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
        //persist/save the model in db
        Restaurant savedRestaurant = restaurantRespository.save(restaurant);
        // prepare response dto from model
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }

    @Override
    public String changeOpenedStatus(int id) {
        //check whether id is valid or not
        if(!validationUtils.validateRestaurantId(id)){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

        Restaurant restaurant = restaurantRespository.findById(id).get();
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRespository.save(restaurant);

        if(restaurant.isOpened()){
            return "Restaurant is opened now!!!";
        }

        return "Restaurant is closed";
    }

    @Override
    public RestaurantResponse addMenuItemtToRestaurant(MenuItemRequest menuItemRequest) {
            // check restaurant is valid or not
            if(!validationUtils.validateRestaurantId(menuItemRequest.getRestaurantId())){
                throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
            }

            Restaurant restaurant = restaurantRespository.findById(menuItemRequest.getRestaurantId()).get();
            // make food entity
            MenuItem menuItem = MenuItemTransformer.MenuRequestToMenuItem(menuItemRequest);
            menuItem.setRestaurant(restaurant);

            restaurant.getMenuItems().add(menuItem);

            // save rest and food
            Restaurant savedRestaurant = restaurantRespository.save(restaurant);

            // prepare response
            return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
        }

}
