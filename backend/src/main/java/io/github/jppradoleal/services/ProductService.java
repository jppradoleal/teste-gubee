package io.github.jppradoleal.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jppradoleal.domain.Product;
import io.github.jppradoleal.dto.ProductDTO;
import io.github.jppradoleal.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	@Transactional
	public List<ProductDTO> findAll() {
		return repository.findAll().stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
	}
	
	@Transactional
	public ProductDTO findOne(Long id) {
		Product product = repository.findById(id).orElseThrow();
		return new ProductDTO(product);
	}
}
