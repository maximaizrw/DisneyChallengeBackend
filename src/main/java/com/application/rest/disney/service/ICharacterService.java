package com.application.rest.disney.service;

import com.application.rest.disney.entities.Character;

import java.util.List;
import java.util.Optional;

public interface ICharacterService {
    Optional<Character> findById(Long id);
    Optional<Character> findByName(String name);
    List<Character> findAll();
    Character save(Character character);
    void deleteById(Long id);

}
