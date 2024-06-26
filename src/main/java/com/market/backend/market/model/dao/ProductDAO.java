package com.market.backend.market.model.dao;

import com.market.backend.market.model.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
    boolean existsByProductName(String productName);
}
