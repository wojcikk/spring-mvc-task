package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Food;

public interface CartService {
     void updateCart(Customer customer, Food food, int pieces);
}
