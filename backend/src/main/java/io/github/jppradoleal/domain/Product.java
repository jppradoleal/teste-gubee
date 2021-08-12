package io.github.jppradoleal.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column
	private String description;
	
	@ManyToMany
	@JoinTable(
		name = "products_targets",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "target_id"))
	private List<TargetMarket> targets;
	
	@ManyToMany
	@JoinTable(
		name = "products_techs",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "tech_id"))
	private List<Tech> techs;

	public Product() {
	}

	public Product(Long id, String name, String description, List<TargetMarket> targets, List<Tech> techs) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.targets = targets;
		this.techs = techs;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TargetMarket> getTarget() {
		return targets;
	}

	public void setTarget(List<TargetMarket> targets) {
		this.targets = targets;
	}

	public List<Tech> getTechs() {
		return techs;
	}

	public void setTechs(List<Tech> techs) {
		this.techs = techs;
	}

	public Long getId() {
		return id;
	} 
}
