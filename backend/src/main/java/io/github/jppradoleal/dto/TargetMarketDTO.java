package io.github.jppradoleal.dto;

import java.util.List;
import java.util.stream.Collectors;

import io.github.jppradoleal.domain.TargetMarket;

public class TargetMarketDTO {
	private Long id;
	private String name;
	private List<ProductDTO> products;

	public TargetMarketDTO() {
	}

	public TargetMarketDTO(TargetMarket entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.products = entity.getProducts().stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

}
