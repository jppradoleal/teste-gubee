package io.github.jppradoleal.dto;

import io.github.jppradoleal.domain.TargetMarket;

public class ProductTargetMarketDTO {
	private Long id;
	private String name;

	public ProductTargetMarketDTO(TargetMarket entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
