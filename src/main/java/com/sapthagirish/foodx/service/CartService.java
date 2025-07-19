package com.sapthagirish.foodx.service;

import com.sapthagirish.foodx.dto.request.FoodItemRequest;
import com.sapthagirish.foodx.dto.response.CartStatusResponse;

public interface CartService {
    public CartStatusResponse addFoodItemToCart(FoodItemRequest foodItemRequest);
}
