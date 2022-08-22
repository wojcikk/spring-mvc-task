package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.repository.FoodRepository;
import com.epam.training.fooddelivery.domain.Food;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultFoodService implements FoodService {
    private final FoodRepository foodRepository;

    public DefaultFoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    @Transactional
    public List<Food> listAllFood() {
        return this.foodRepository.findAll();
    }
}
