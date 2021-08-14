package io.github.jppradoleal.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import io.github.jppradoleal.dto.ProductDTO;
import io.github.jppradoleal.services.ProductService;
import io.github.jppradoleal.utils.TestUtils;

@WebMvcTest(
		controllers = {ProductsController.class}, 
		excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ProductService.class))
class ProductsControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProductService service;
	
	@Test
	void getOnProductsReturnAListOfProducts_test() throws Exception {
		List<ProductDTO> products = TestUtils.loadProductList();
		
		when(service.findAll()).thenReturn(products);
		
		String expectedName = products.get(0).getName();
		String expectedDescription = products.get(0).getDescription();
		String expectedTechName = products.get(0).getTechs().get(0).getName();
		String expectedTargetName = products.get(0).getTargetMarket().get(0).getName();
		
		mvc.perform(
			get("/products")
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].name").value(expectedName))
		.andExpect(jsonPath("$[0].description").value(expectedDescription))
		.andExpect(jsonPath("$[0].targetMarket[0].name").value(expectedTargetName))
		.andExpect(jsonPath("$[0].techs[0].name").value(expectedTechName));
	}
	
	@Test
	void getOnProductIdReturnOneProduct_test() throws Exception {
		ProductDTO product = TestUtils.loadProduct();
		when(service.findOne(Mockito.anyLong())).thenReturn(product);

		String expectedName = product.getName();
		String expectedDescription = product.getDescription();
		String expectedTechName = product.getTechs().get(0).getName();
		String expectedTargetName = product.getTargetMarket().get(0).getName();
		
		mvc.perform(
			get("/products/{id}", 1l)
			.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.name").value(expectedName))
		.andExpect(jsonPath("$.description").value(expectedDescription))
		.andExpect(jsonPath("$.targetMarket[0].name").value(expectedTargetName))
		.andExpect(jsonPath("$.techs[0].name").value(expectedTechName));
	}
}
