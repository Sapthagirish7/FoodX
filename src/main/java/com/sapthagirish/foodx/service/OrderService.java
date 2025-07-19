package com.sapthagirish.foodx.service;

import com.sapthagirish.foodx.dto.response.OrderResponse;

public interface OrderService {
   public OrderResponse placeOrder(String customerMobile);
}
