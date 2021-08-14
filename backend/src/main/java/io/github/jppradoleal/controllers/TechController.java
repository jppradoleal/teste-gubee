package io.github.jppradoleal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.jppradoleal.dto.TechDTO;
import io.github.jppradoleal.services.TechService;

@RequestMapping(path = "/techs")
@RestController
public class TechController {
	@Autowired
	TechService service;
	
	@GetMapping()
	public ResponseEntity<List<TechDTO>> getByName(
			@RequestParam(required = false, defaultValue = "") String name
		) {
		List<TechDTO> techs = service.findByName(name);
		return ResponseEntity.ok().body(techs);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<TechDTO> getTech(@PathVariable Long id) {
		TechDTO tech = service.findOne(id);
		return ResponseEntity.ok().body(tech);
	}
}
