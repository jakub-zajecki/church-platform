package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.Church;

public interface ChurchService {

    public Church findChurchById(Long id);

    public void saveChurch(Church church);

    public Church findChurchByToken(String token);
}
