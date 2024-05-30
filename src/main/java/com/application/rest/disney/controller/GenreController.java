package com.application.rest.disney.controller;

import com.application.rest.disney.controller.dto.GenreDTO;
import com.application.rest.disney.entities.Genre;
import com.application.rest.disney.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private IGenreService genreService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody GenreDTO genreDTO) throws URISyntaxException {
        genreService.save(Genre.builder().
                title(genreDTO.getTitle()).
                image(genreDTO.getImage()).build());
        return ResponseEntity.created(new URI("/genre")).build();
    }
}
