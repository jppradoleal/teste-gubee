package io.github.jppradoleal.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import io.github.jppradoleal.domain.Tech;

public class TechDTO {
	private Long id;
	private String name;
	private List<ProductDTO> products;

	public TechDTO() {
	}

	public TechDTO(Tech entity) {
		super();
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechDTO other = (TechDTO) obj;
		return Objects.equals(id, other.id);
	}

}
