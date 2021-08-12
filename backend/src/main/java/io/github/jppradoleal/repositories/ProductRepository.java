package io.github.jppradoleal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.jppradoleal.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
