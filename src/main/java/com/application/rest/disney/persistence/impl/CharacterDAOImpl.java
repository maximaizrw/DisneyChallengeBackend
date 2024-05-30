package com.application.rest.disney.persistence.impl;

import com.application.rest.disney.entities.Character;
import com.application.rest.disney.persistence.ICharacterDAO;
import com.application.rest.disney.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CharacterDAOImpl implements ICharacterDAO {
    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public Optional<Character> findById(Long id) {
        return characterRepository.findById(id);
    }

    @Override
    public Optional<Character> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public List<Character> findAll() {
        return (List<Character>) characterRepository.findAll();
    }

    @Override
    public Character save(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public void deleteById(Long id) {
        characterRepository.deleteById(id);
    }
}
