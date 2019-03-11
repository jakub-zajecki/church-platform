package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.Priest;

public interface PriestService {

    public void savePriest(Priest priest);

    public void delatePriest(Long id);
}
