package com.sapthagirish.foodx.transformer;

import com.sapthagirish.foodx.dto.response.FoodItemResponse;
import com.sapthagirish.foodx.model.FoodItem;

public class FoodItemTransformer {
    public static FoodItemResponse FoodToFoodResponse(FoodItem food){
        return FoodItemResponse.builder()
                .dishName(food.getMenuItem().getDishName())
                .price(food.getMenuItem().getPrice())
                .category(food.getMenuItem().getFoodCategory())
                .veg(food.getMenuItem().isVeg())
                .quantityAdded(food.getRequiredQuantity())
                .build();
    }
}
