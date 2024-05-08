package com.market.backend.market.model.dao;

import com.market.backend.market.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {
}
