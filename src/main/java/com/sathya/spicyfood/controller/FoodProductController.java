package com.sathya.spicyfood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.spicyfood.dto.FoodProductDto;
import com.sathya.spicyfood.entity.FoodProduct;
import com.sathya.spicyfood.enums.Category;
import com.sathya.spicyfood.service.FoodProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:5173")
public class FoodProductController {
     
	@Autowired
	private FoodProductService foodProductService;
	
//	post all food items 
	@PostMapping
	public ResponseEntity<List<FoodProduct>> addProducts( @RequestBody List<FoodProduct> products) {

	    List<FoodProduct> savedProducts = foodProductService.saveProducts(products);

	    return ResponseEntity.ok(savedProducts);
	}

    // get all products
    @GetMapping
    public ResponseEntity<List<FoodProductDto>> getAllProducts() {

        List<FoodProductDto> products = foodProductService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    // get products by category
    @GetMapping("/{category}")
    public ResponseEntity<List<FoodProductDto>> getProductsByCategory( @PathVariable Category category) {

    	List<FoodProductDto> products = foodProductService.getProductsByCategory(category);

        return ResponseEntity.ok(products);
    }
}
