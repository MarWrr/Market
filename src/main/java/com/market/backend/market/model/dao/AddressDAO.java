package com.market.backend.market.model.dao;

import com.market.backend.market.model.Address;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AddressDAO extends ListCrudRepository<Address, Long > {

    List<Address> findByUser_Id(Long id);


}
