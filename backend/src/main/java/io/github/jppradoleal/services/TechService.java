package io.github.jppradoleal.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jppradoleal.domain.Tech;
import io.github.jppradoleal.dto.TechDTO;
import io.github.jppradoleal.repositories.TechRepository;

@Service
public class TechService {
	@Autowired
	TechRepository repository;
	
	@Transactional
	public List<TechDTO> findByName(String name) {
		List<Tech> techs = repository.findByName(name);
		return techs.stream().map(e -> new TechDTO(e)).collect(Collectors.toList());
	}
	
	@Transactional
	public List<TechDTO> findByTech(List<String> names) {
		List<Tech> techs = repository.findByNameIn(names);
		return techs.stream().map(e -> new TechDTO(e)).collect(Collectors.toList());
	}
	
	@Transactional
	public TechDTO findOne(Long id) {
		Tech tech = repository.findById(id).orElseThrow();
		return new TechDTO(tech);
	}
}
