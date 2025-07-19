package com.sapthagirish.foodx.service;


import com.sapthagirish.foodx.dto.request.CustomerRequest;
import com.sapthagirish.foodx.dto.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse addCustomer(CustomerRequest customerRequest);

    CustomerResponse findCustomerByMobile(String mobile);
}
