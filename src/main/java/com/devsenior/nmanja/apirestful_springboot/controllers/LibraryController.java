package com.devsenior.nmanja.apirestful_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.apirestful_springboot.models.dto.BookRequest;
import com.devsenior.nmanja.apirestful_springboot.models.dto.BookResponse;
import com.devsenior.nmanja.apirestful_springboot.services.LibraryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



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

    //Obtener libro por id

    @GetMapping("{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return libraryService.getBookById(id);
    }

    @GetMapping("/buscar")
    public List<BookResponse> getByTitleOrAuthor(
        @RequestParam (required = false, defaultValue = "") String searchTerm) {
        return libraryService.getBooksByTitleOrAuthor(searchTerm);
    }

    //Agregar un libro
    @PostMapping
    public BookResponse createBook(
        
        @Valid
        @RequestBody BookRequest book) {
        
        
        return libraryService.create(book);
    }

    //Actualizar libro por id
    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable Long id, @RequestBody BookRequest book) {
        
        return libraryService.update(id, book);
    }
    
    //Borrar libro por id
    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable Long id){
        libraryService.delete(id);
    }
    



    
}
