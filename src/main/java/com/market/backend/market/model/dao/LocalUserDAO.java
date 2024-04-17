package com.market.backend.market.model.dao;

import com.market.backend.market.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocalUserDAO extends CrudRepository<Users, Long> {
    Optional<Users> findByLoginIgnoreCase(String login);

    Optional<Users> findByEmailIgnoreCase(String email);


}
