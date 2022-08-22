package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Order;

public interface OrderService {
    Order createOrder(Customer customer);
}
