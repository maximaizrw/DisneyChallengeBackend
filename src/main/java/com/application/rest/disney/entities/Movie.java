package com.application.rest.disney.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pelicula")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "imagen")
    private String image;
    @Column(name = "titulo")
    private String title;
    @Column(name = "fecha_creacion")
    private String creationDate;
    @Column(name = "calificacion")
    private int rating;
    @ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "id_genero")
    private Genre genre;
}
