package io.github.jppradoleal.dto;

import java.util.List;
import java.util.stream.Collectors;

import io.github.jppradoleal.domain.Product;

public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private List<ProductTargetMarketDTO> targetMarket;
	private List<ProductTechDTO> techs;
	
	public ProductDTO(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.targetMarket = entity.getTarget().stream().map(e -> new ProductTargetMarketDTO(e)).collect(Collectors.toList());
		this.techs = entity.getTechs().stream().map(e -> new ProductTechDTO(e)).collect(Collectors.toList());
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String descricao) {
		this.description = descricao;
	}

	public List<ProductTargetMarketDTO> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(List<ProductTargetMarketDTO> targetMarket) {
		this.targetMarket = targetMarket;
	}

	public List<ProductTechDTO> getTechs() {
		return techs;
	}

	public void setTechs(List<ProductTechDTO> techs) {
		this.techs = techs;
	}
}
