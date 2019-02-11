package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.Intention;
import org.springframework.data.repository.CrudRepository;

public interface IntentionRepository extends CrudRepository<Intention, Long> {
}
