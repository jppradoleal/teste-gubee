package io.github.jppradoleal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.jppradoleal.domain.Tech;

@Repository
public interface TechRepository extends JpaRepository<Tech, Long>{
	@Query("select tech from Tech tech where tech.name like %?1%")
	List<Tech> findByName(String name);
	
	List<Tech> findByNameIn(List<String> name);
}
