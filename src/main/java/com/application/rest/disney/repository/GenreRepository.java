package com.application.rest.disney.repository;

import com.application.rest.disney.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>{

}
