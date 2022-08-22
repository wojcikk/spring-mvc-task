package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Food;
import com.epam.training.fooddelivery.domain.OrderItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DefaultCartService implements CartService {
    @Override
    public void updateCart(Customer customer, Food food, int pieces) {
        addOrderItem(new OrderItem(pieces, new BigDecimal(pieces * food.getPrice().intValue()), food), customer.getCart());
        setPriceOfCart(customer.getCart().getOrderItems(), customer.getCart());
    }

    private void addOrderItem(OrderItem item, Cart cart) {
        if(item.getPieces() == 0) {
            deleteOrderItem(item, cart);
            return;
        }

        for(OrderItem orderItem : cart.getOrderItems()) {
            if(orderItem.getFood().getName().equals(item.getFood().getName())) {
                orderItem.setFood(item.getFood());
                orderItem.setPieces(item.getPieces());
                orderItem.setPrice(item.getPrice());
                return;
            }
        }

        cart.getOrderItems().add(item);
    }

    private void deleteOrderItem(OrderItem item, Cart cart) {
        int index = 0;

        for(OrderItem orderItem : cart.getOrderItems()) {
            if (orderItem.getFood().getName().equals(item.getFood().getName())) {
                cart.getOrderItems().remove(index);
                return;
            }
            index++;
        }
    }

    public void setPriceOfCart(List<OrderItem> items, Cart cart) {
        cart.setPrice(new BigDecimal(0));
        for(OrderItem item : items) {
            cart.setPrice(new BigDecimal(cart.getPrice().intValue() + item.getPrice().intValue()));
        }
    }
}
