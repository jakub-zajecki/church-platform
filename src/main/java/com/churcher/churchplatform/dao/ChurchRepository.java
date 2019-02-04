package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.Church;
import org.springframework.data.repository.CrudRepository;

public interface ChurchRepository extends CrudRepository<Church,Long> {

    public Church findChurchById(Long churchId);
}
