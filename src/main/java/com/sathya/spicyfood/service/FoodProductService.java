package com.sathya.spicyfood.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.spicyfood.dto.FoodProductDto;
import com.sathya.spicyfood.entity.FoodProduct;
import com.sathya.spicyfood.enums.Category;
import com.sathya.spicyfood.repository.FoodProductRepository;

@Service
public class FoodProductService {

    @Autowired
    private FoodProductRepository foodProductRepository;

    // save products
    public List<FoodProduct> saveProducts(
            List<FoodProduct> foodProducts) {

        List<FoodProduct> savedProducts =
                foodProductRepository.saveAll(foodProducts);

        return savedProducts;
    }

    // get all products
    public List<FoodProductDto> getAllProducts() {

        List<FoodProduct> products =
                foodProductRepository.findAll();

        List<FoodProductDto> productDtos =
                products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return productDtos;
    }

    // get products by category
    public List<FoodProductDto>
    getProductsByCategory(Category category) {

        List<FoodProduct> products =
                foodProductRepository
                .findByCategory(category);

        List<FoodProductDto> productDtos =
                products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

        return productDtos;
    }

    // convert entity to dto
    private FoodProductDto convertToDto(
            FoodProduct foodProduct) {

        FoodProductDto dto =
                new FoodProductDto();

        dto.setName(foodProduct.getName());
        dto.setPrice(foodProduct.getPrice());
        dto.setDescription(foodProduct.getDescription());
        dto.setImage(foodProduct.getImage());

        return dto;
    }
}