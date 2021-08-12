package io.github.jppradoleal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jppradoleal.dto.ProductDTO;
import io.github.jppradoleal.services.ProductService;

@RequestMapping(path = "/products")
@RestController
public class ProductsController {
	@Autowired
	private ProductService service;
	
	@GetMapping()
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		List<ProductDTO> products = service.findAll();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
		ProductDTO product = service.findOne(id);
		return ResponseEntity.ok().body(product);
	}
}
