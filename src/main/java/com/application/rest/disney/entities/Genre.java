package com.application.rest.disney.entities;

import jakarta.persistence.*;
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
@Table(name = "Genero")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String title;
    @Column(name = "imagen")
    private String image;
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private List<Movie> movies;
}
