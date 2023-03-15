package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductnotFoundException;

@RestController
public class ExceptionController {
	 private static Map<String,Product > productRepo = new HashMap<>();
	 static {
		 Product  products = new Product();
		 products.setId("1");
		 products.setName("hp");
		 productRepo.put(products.getName(), products);
		 
		 
		 Product  detailProduct = new Product();
		 detailProduct.setId("2");
		 detailProduct.setName("dell");
		 productRepo.put(detailProduct.getName(),detailProduct);
		 
	 }
	 
	@PutMapping("/product/{id}")
	public ResponseEntity<Object> updateData(@PathVariable String id,@RequestBody Product product){
		if(!productRepo.containsKey(id))throw new ProductnotFoundException();
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return  new ResponseEntity<>("product updated successfully",HttpStatus.OK);
	}
		
	}
	
	
	
	
	
	
	

