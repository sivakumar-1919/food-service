package com.sathya.spicyfood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.spicyfood.entity.FoodProduct;
import com.sathya.spicyfood.enums.Category;

@Repository
public interface FoodProductRepository extends JpaRepository<FoodProduct, Long> {

	

	List<FoodProduct> findByCategory(Category category);

}
