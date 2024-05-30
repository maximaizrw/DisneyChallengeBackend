package com.application.rest.disney.repository;

import com.application.rest.disney.entities.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
   Optional<Character> findByName(String name);
}
