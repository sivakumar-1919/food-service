package com.sathya.spicyfood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodProductDto {

	
	private Long id;   
	   
	private String name;

    private Double price;

    private String description;

    private String image;
    
}
