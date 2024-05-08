package com.market.backend.market.model.dao;

import com.market.backend.market.model.Orders;
import com.market.backend.market.model.Users;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<Orders, Long> {
    List<Orders> findByUsers(Users users);
}
