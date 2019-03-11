package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.Priest;
import org.springframework.data.repository.CrudRepository;

public interface PriestRepository extends CrudRepository<Priest,Long> {
}
