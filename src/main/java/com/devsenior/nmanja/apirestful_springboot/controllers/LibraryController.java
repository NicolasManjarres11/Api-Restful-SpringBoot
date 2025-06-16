package com.devsenior.nmanja.apirestful_springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.apirestful_springboot.models.dto.BookRequest;
import com.devsenior.nmanja.apirestful_springboot.models.dto.BookResponse;
import com.devsenior.nmanja.apirestful_springboot.services.LibraryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Sistema Simplificado de Gestión de Biblioteca", description = "API para gestionar libros")
public class LibraryController {

    private final LibraryService libraryService;

    //Obtener todos los libros
    @Operation(summary = "Obtener todos los libros")
    @ApiResponse(responseCode = "200", description = "Libros encontrados")
    @GetMapping
    public List<BookResponse> getAllBooks() {
        return libraryService.getAll();
    }

    //Obtener libro por id
    @Operation(summary = "Buscar libro por titulo")
    @ApiResponse(responseCode = "200", description = "Libro encontrado")
    @ApiResponse(responseCode = "404", description = "No se encontró libro")
    @GetMapping("{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return libraryService.getBookById(id);
    }

    //Buscar un libro por nombre de autor o titulo
    @Operation(summary = "Buscar libros por título o autor")
    @ApiResponse(responseCode = "200", description = "Libros encontrados")
    @ApiResponse(responseCode = "404", description = "No se encontraron libros")
    @GetMapping("/buscar")
    public List<BookResponse> getByTitleOrAuthor(
        @Parameter(description = "Termino de busqueda (titulo o autor)")
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

    //Prestar un libro
    @PostMapping("/{id}/prestar")
    public BookResponse loanBook(@PathVariable Long id) {
        
        
        return libraryService.setLoan(id);
    }
    

    //Actualizar libro por id
    @PutMapping("/{id}")
    public BookResponse updateBook
        (
        @Valid    
        @PathVariable Long id, @RequestBody BookRequest book) {
        
        return libraryService.update(id, book);
    }
    
    //Borrar libro por id
    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable Long id){
        libraryService.delete(id);
    }


    



    
}
