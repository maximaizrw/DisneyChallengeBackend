package com.application.rest.disney.persistence;

import com.application.rest.disney.entities.Genre;

public interface IGenreDAO {
    void save(Genre genre);
}
