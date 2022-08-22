package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.User;

public interface CustomerService {
    Customer authenticate(User user);
}
