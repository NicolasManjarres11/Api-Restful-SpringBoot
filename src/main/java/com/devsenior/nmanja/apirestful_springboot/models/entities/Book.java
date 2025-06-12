package com.devsenior.nmanja.apirestful_springboot.models.entities;

import java.time.LocalDate;

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
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "state", nullable = false)
    private String state;


    
}
