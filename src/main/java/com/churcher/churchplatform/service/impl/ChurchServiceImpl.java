package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.ChurchRepository;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.service.ChurchService;
import org.springframework.stereotype.Service;

@Service
public class ChurchServiceImpl implements ChurchService {

    private ChurchRepository churchRepository;

    public ChurchServiceImpl(ChurchRepository churchRepository) {
        this.churchRepository = churchRepository;
    }

    @Override
    public Church findChurchById(Long id) {
        return churchRepository.findChurchById(id);
    }

    @Override
    public void saveChurch(Church church) {
        churchRepository.save(church);
    }
}
