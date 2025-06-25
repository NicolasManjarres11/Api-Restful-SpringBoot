package com.devsenior.nmanja.apirestful_springboot.models.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class BookRequest {

    @Schema(description = "Titulo del libro", example ="Don Quijote de la Mancha")
    @NotNull
    private String title;

    @Schema(description = "Autor del libro", example ="Miguel de Cervantes")
    @NotNull
    private String author;

    @Schema(description = "Código ISBN del libro", example ="545-736-232")
    @NotNull
    private String isbn;

    @Schema(description = "Fecha de lanzamiento", example ="2006-03-25")
    @NotNull
    private LocalDate releaseDate;


    @Schema(description = "Género del libro", example ="Drama")
    private String genre;

    @Schema(description = "Estado del libro", example ="PRESTADO, DISPONIBLE, ETC.")
    @NotNull
    private String state;
}
