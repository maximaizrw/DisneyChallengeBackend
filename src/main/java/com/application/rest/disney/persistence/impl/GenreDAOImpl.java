package com.application.rest.disney.persistence.impl;

import com.application.rest.disney.entities.Genre;
import com.application.rest.disney.persistence.IGenreDAO;
import com.application.rest.disney.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreDAOImpl implements IGenreDAO {

        @Autowired
        private GenreRepository genreRepository;

        @Override
        public void save(Genre genre) {
            genreRepository.save(genre);
        }
}
