package com.sapthagirish.foodx.controller;

import com.sapthagirish.foodx.dto.request.MenuItemRequest;
import com.sapthagirish.foodx.dto.request.RestaurantRequest;
import com.sapthagirish.foodx.dto.response.RestaurantResponse;
import com.sapthagirish.foodx.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    final RestaurantServiceImpl restaurantService;
    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add")
    public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);
    }
    @PutMapping("/update/status")
    public ResponseEntity changeOpenedStatus(@RequestParam int id){
        String message = restaurantService.changeOpenedStatus(id);
        return new ResponseEntity(message,HttpStatus.ACCEPTED);
    }
    @PostMapping("/add/menu")
    public ResponseEntity addMenuItemToRestaurant(@RequestBody MenuItemRequest menuItemRequest){
        RestaurantResponse restaurantResponse = restaurantService.addMenuItemtToRestaurant(menuItemRequest);
        return new ResponseEntity(restaurantResponse,HttpStatus.CREATED);
    }
}
