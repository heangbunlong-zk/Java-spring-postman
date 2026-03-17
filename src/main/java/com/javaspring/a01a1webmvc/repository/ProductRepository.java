package com.javaspring.a01a1webmvc.repository;

import com.javaspring.a01a1webmvc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
