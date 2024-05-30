package com.application.rest.disney.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Personaje")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "imagen")
    private String image;
    @NotBlank
    @Size(max = 50)
    @Column(name = "nombre")
    private String name;
    @NotNull
    @PositiveOrZero(message = "La edad debe ser mayor o igual a 0")
    @Column(name = "edad")
    private int age;
    @NotNull
    @PositiveOrZero
    @Column(name = "peso")
    private double weight;
    @NotBlank
    @Size(max = 200)
    @Column(name = "historia")
    private String history;
    @ManyToMany(targetEntity = Movie.class)
    @JoinTable(
            name = "Personaje_Pelicula",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private List<Movie> movies;
}
