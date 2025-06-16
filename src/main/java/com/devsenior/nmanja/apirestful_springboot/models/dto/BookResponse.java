package com.devsenior.nmanja.apirestful_springboot.models.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data

public class BookResponse {

    @Schema(description = "Identificador único del libro", example = "17")
    private Long id;

    @Schema(description = "Titulo del libro", example ="Don Quijote de la Mancha")
    private String title;

    @Schema(description = "Autor del libro", example ="Miguel de Cervantes")
    private String author;

    @Schema(description = "Código ISBN del libro", example ="545-736-232")
    private String isbn;

    @Schema(description = "Fecha de lanzamiento", example ="2006-03-25")
    private LocalDate releaseDate;

    @Schema(description = "Género del libro", example ="Drama")
    private String genre;

    @Schema(description = "Estado del libro", example ="PRESTADO, DISPONIBLE, ETC.")
    private String state;
    
}
