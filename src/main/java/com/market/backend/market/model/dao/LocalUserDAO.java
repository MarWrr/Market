package com.market.backend.market.model.dao;

import com.market.backend.market.model.Klienci;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocalUserDAO extends CrudRepository<Klienci, Long> {
    Optional<Klienci> findByLoginIgnoreCase(String login);

    Optional<Klienci> findByEmailIgnoreCase(String email);


}
