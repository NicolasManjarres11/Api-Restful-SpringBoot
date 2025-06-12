package com.devsenior.nmanja.apirestful_springboot.models.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class BookRequest {


    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    @NotNull
    private LocalDate releaseDate;


    private String genre;

    @NotNull
    private String state;
}
