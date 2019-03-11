package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
