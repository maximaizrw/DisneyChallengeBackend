package com.application.rest.disney.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterDTO {
    private String name;
    private int age;
    private double weight;
    private String history;
    private String image;
}
