package com.sapthagirish.foodx.transformer;

import com.sapthagirish.foodx.dto.response.CartResponse;
import com.sapthagirish.foodx.model.Cart;

import java.util.ArrayList;

public class CartTransformer {
    public static CartResponse CartToCartResponse(Cart cart){
        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }
}
