package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.PriestRepository;
import com.churcher.churchplatform.model.Priest;
import com.churcher.churchplatform.service.PriestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriestServiceImpl implements PriestService {

    private PriestRepository priestRepository;

    @Autowired
    public PriestServiceImpl(PriestRepository priestRepository) {
        this.priestRepository = priestRepository;
    }

    @Override
    public void savePriest(Priest priest) {
        priestRepository.save(priest);
    }

    @Override
    public void delatePriest(Long id) {
        priestRepository.deleteById(id);
    }
}
