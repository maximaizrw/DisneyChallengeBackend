package com.application.rest.disney.service.impl;

import com.application.rest.disney.entities.Character;
import com.application.rest.disney.persistence.ICharacterDAO;
import com.application.rest.disney.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements ICharacterService {
    @Autowired
    private ICharacterDAO characterDAO;

    @Override
    public Optional<Character> findById(Long id) {
        return characterDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Character> findByName(String name) {
        return characterDAO.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Character> findAll() {
        return characterDAO.findAll();
    }

    @Override
    @Transactional
    public Character save(Character character) {
        return characterDAO.save(character);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        characterDAO.deleteById(id);
    }
}
