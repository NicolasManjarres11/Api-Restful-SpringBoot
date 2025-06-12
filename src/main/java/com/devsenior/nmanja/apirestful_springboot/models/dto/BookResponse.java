package com.devsenior.nmanja.apirestful_springboot.models.dto;

import java.time.LocalDate;

import lombok.Data;

@Data

public class BookResponse {

    private Long id;

    private String title;


    private String author;


    private String isbn;


    private LocalDate releaseDate;


    private String genre;


    private String state;
    
}
