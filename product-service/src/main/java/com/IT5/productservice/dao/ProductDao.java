package com.IT5.productservice.dao;

import com.IT5.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product , Integer> {
}
