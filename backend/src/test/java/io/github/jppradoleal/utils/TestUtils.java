package io.github.jppradoleal.utils;

import java.util.ArrayList;
import java.util.List;

import io.github.jppradoleal.dto.ProductDTO;
import io.github.jppradoleal.dto.ProductTargetMarketDTO;
import io.github.jppradoleal.dto.ProductTechDTO;
import io.github.jppradoleal.dto.TargetMarketDTO;

public class TestUtils {

	static public ProductTargetMarketDTO loadProductTargetMarket() {
		ProductTargetMarketDTO targetMarket = new ProductTargetMarketDTO();
		targetMarket.setId(1l);
		targetMarket.setName("Ecommerce");
	
		return targetMarket;
	}
	
	static public ProductTechDTO loadProductTech() {
		ProductTechDTO tech = new ProductTechDTO();
		tech.setId(1l);
		tech.setName("Java");
		
		return tech;
	}
	
	static public ProductDTO loadProduct() {	
		List<ProductTargetMarketDTO> targets = new ArrayList<>();
		targets.add(loadProductTargetMarket());
		
		List<ProductTechDTO> techs = new ArrayList<>();
		techs.add(loadProductTech());

		ProductDTO product = new ProductDTO();
		product.setName("Test");
		product.setId(1l);
		product.setDescription("Description test");
		product.setTechs(techs);
		product.setTargetMarket(targets);
	
		return product;
	}
	
	static public List<ProductDTO> loadProductList() {
		List<ProductDTO> products = new ArrayList<>();
		products.add(loadProduct());
		
		return products;
	}
}
