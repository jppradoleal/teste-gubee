package io.github.jppradoleal.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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

import io.github.jppradoleal.dto.TechDTO;
import io.github.jppradoleal.services.TechService;
import io.github.jppradoleal.utils.TestUtils;

@WebMvcTest(
		controllers = {TechController.class}, 
		excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = TechService.class))
class TechControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TechService service;
	
	@Test
	void getOnTechsReturnAListOfTechs_test() throws Exception {
		TechDTO tech = loadTech(1l, "Java");
		TechDTO secondTech = loadTech(2l, "Kafka");
		when(service.findByName(Mockito.anyString())).thenReturn(loadTechList());
		
		String name = tech.getName();
		String productName = tech.getProducts().get(0).getName();
		
		String secondName = secondTech.getName();
		String secondProductName = secondTech.getProducts().get(0).getName();
		
		mvc.perform(
				get("/techs")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0].name").value(name))
		.andExpect(jsonPath("$[0].products[0].name").value(productName))
		.andExpect(jsonPath("$[1].name").value(secondName))
		.andExpect(jsonPath("$[1].products[0].name").value(secondProductName));
	}

	@Test
	void getOnTechsWithNameReturnTechWithName_test() throws Exception {
		TechDTO tech = loadTech(1l, "Java");
		when(service.findByTech(Mockito.anyList())).thenReturn(loadTechList());

		String name = tech.getName();
		String productName = tech.getProducts().get(0).getName();

		mvc.perform(
				get("/techs")
				.param("techNames", tech.getName(), "Kotlin")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0].name").value(name))
		.andExpect(jsonPath("$[0].products[0].name").value(productName));

	}

	private TechDTO loadTech(Long id, String name) {
		TechDTO tech = new TechDTO();
		tech.setId(id);
		tech.setName(name);
		tech.setProducts(TestUtils.loadProductList());
		
		return tech;
	}
	
	private List<TechDTO> loadTechList() {
		List<TechDTO> techs = new ArrayList<>();
		techs.add(loadTech(1l, "Java"));
		techs.add(loadTech(2l, "Kafka"));
		
		return techs;
	}
}
