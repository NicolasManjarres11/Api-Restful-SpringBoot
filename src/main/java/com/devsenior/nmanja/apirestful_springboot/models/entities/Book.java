package com.devsenior.nmanja.apirestful_springboot.models.entities;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @Schema(description = "Identificador único del libro", example = "17")
    private Long id;

    @Schema(description = "Titulo del libro", example ="Don Quijote de la Mancha")  
    @Column(name="title", nullable = false)
    private String title;

    @Schema(description = "Autor del libro", example ="Miguel de Cervantes")
    @Column(name = "author", nullable = false)
    private String author;

    @Schema(description = "Código ISBN del libro", example ="545-736-232")
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Schema(description = "Fecha de lanzamiento", example ="2006-03-25")
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Schema(description = "Género del libro", example ="Drama")
    @Column(name = "genre")
    private String genre;
    
    @Schema(description = "Estado del libro", example ="PRESTADO, DISPONIBLE, ETC.")
    @Column(name = "state", nullable = false)
    private String state;


    
}
