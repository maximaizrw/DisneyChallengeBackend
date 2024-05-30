package com.application.rest.disney.service.impl;

import com.application.rest.disney.entities.Genre;
import com.application.rest.disney.persistence.IGenreDAO;
import com.application.rest.disney.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements IGenreService {
    @Autowired
    private IGenreDAO genreDAO;
    @Override
    public void save(Genre genre) {
        genreDAO.save(genre);
    }
}
