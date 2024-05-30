package com.application.rest.disney.persistence;

import com.application.rest.disney.entities.Character;

import java.util.List;
import java.util.Optional;

public interface ICharacterDAO {
    Optional<Character> findById(Long id);
    Optional<Character> findByName(String name);
    List<Character> findAll();
    Character save(Character character);
    void deleteById(Long id);
}
