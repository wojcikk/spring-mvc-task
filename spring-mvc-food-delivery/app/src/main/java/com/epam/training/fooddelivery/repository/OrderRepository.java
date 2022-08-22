package com.epam.training.fooddelivery.repository;

import com.epam.training.fooddelivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
