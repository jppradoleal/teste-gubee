package io.github.jppradoleal.dto;

import io.github.jppradoleal.domain.Tech;

public class ProductTechDTO {
	private Long id;
	private String name;

	public ProductTechDTO() {
	}

	public ProductTechDTO(Tech entity) {
		super();
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
