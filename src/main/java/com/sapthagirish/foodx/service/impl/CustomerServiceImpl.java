package com.sapthagirish.foodx.service.impl;

import com.sapthagirish.foodx.dto.request.CustomerRequest;
import com.sapthagirish.foodx.dto.response.CustomerResponse;
import com.sapthagirish.foodx.exception.CustomerNotFoundException;
import com.sapthagirish.foodx.model.Cart;
import com.sapthagirish.foodx.model.Customer;
import com.sapthagirish.foodx.service.CustomerService;
import com.sapthagirish.foodx.repository.CustomerRepository;
import com.sapthagirish.foodx.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerTransformer.CustomerToCustomerResponse(savedCustomer);
    }

    @Override
    public CustomerResponse findCustomerByMobile(String mobile) {
        Customer customer = customerRepository.findByMobileNo(mobile);
        if(customer==null){
            throw new CustomerNotFoundException("Invalid mobile no!!!");
        }
        return CustomerTransformer.CustomerToCustomerResponse(customer);
    }
}
