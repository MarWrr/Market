package com.market.backend.market.model.dao;

import com.market.backend.market.model.Users;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface LocalUserDAO extends ListCrudRepository<Users, Long> {
    Optional<Users> findByLoginIgnoreCase(String login);

    Optional<Users> findByEmailIgnoreCase(String email);


}
