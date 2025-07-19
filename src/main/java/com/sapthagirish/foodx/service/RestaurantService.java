package com.sapthagirish.foodx.service;

import com.sapthagirish.foodx.dto.request.MenuItemRequest;
import com.sapthagirish.foodx.dto.request.RestaurantRequest;
import com.sapthagirish.foodx.dto.response.RestaurantResponse;

public interface RestaurantService {
    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest);

    public String changeOpenedStatus(int id);

    public RestaurantResponse addMenuItemtToRestaurant(MenuItemRequest menuItemRequest);
}
