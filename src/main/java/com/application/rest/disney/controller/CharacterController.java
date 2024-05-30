package com.application.rest.disney.controller;

import com.application.rest.disney.controller.dto.CharacterDTO;
import com.application.rest.disney.controller.dto.CharacterSearchDTO;
import com.application.rest.disney.entities.Character;
import com.application.rest.disney.service.ICharacterService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private ICharacterService characterService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<CharacterSearchDTO> characterDTOList = characterService.findAll().stream().map(character -> CharacterSearchDTO.builder().
                id(character.getId()).
                name(character.getName()).
                image(character.getImage()).build()).toList();
        if (characterDTOList.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(characterDTOList);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CharacterDTO characterDTO) throws URISyntaxException {
        characterService.save(Character.builder().
                name(characterDTO.getName()).
                age(characterDTO.getAge()).
                weight(characterDTO.getWeight()).
                history(characterDTO.getHistory()).
                image(characterDTO.getImage()).build());
        return ResponseEntity.created(new URI("/characters")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CharacterDTO characterDTO){
        Optional<Character> characterOptional = characterService.findById(id);
        if (characterOptional.isPresent()){
            Character character = characterOptional.get();
            character.setName(characterDTO.getName());
            character.setAge(characterDTO.getAge());
            character.setWeight(characterDTO.getWeight());
            character.setHistory(characterDTO.getHistory());
            character.setImage(characterDTO.getImage());
            characterService.save(character);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id != null) {
            characterService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


}
