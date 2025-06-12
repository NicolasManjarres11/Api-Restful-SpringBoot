package com.devsenior.nmanja.apirestful_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.apirestful_springboot.models.dto.BookRequest;
import com.devsenior.nmanja.apirestful_springboot.models.dto.BookResponse;
import com.devsenior.nmanja.apirestful_springboot.services.LibraryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/libros")
public class LibraryController {

    private final LibraryService libraryService;

    //Obtener todos los libros
    @GetMapping
    public List<BookResponse> getAllBooks() {
        return libraryService.getAll();
    }

    //Agregar un libro
    @PostMapping
    public BookResponse createBook(
        
        @Valid
        @RequestBody BookRequest book) {
        
        
        return libraryService.create(book);
    }
    
    



    
}
