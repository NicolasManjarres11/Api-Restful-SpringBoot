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
    @Operation(summary = "Buscar libro por id")
    @ApiResponse(responseCode = "200", description = "Libro encontrado")
    @ApiResponse(responseCode = "404", description = "No se encontró libro")
    @GetMapping("{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return libraryService.getBookById(id);
    }

    //Buscar un libro por nombre de autor o titulo
    @Operation(summary = "Buscar libros por título o autor")
    @ApiResponse(responseCode = "200", description = "Libros encontrados")
    @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    @GetMapping("/buscar")
    public List<BookResponse> getByTitleOrAuthor(
        @Parameter(description = "Termino de busqueda (titulo o autor)")
        @RequestParam (required = false, defaultValue = "") String searchTerm) {
        return libraryService.getBooksByTitleOrAuthor(searchTerm);
    }

    @ApiResponse(responseCode = "200", description = "Libro creado")
    @ApiResponse(responseCode = "400", description = "Los datos ingresados no son válidos")
    @Operation(summary = "Crear un libro nuevo")
    //Agregar un libro
    @PostMapping
    public BookResponse createBook(
        
        @Valid
        @RequestBody BookRequest book) {
        
        
        return libraryService.create(book);
    }

    @Operation(summary = "Prestar un libro buscado por id")
    @ApiResponse(responseCode = "200", description = "Libro prestado")
    @ApiResponse(responseCode = "500", description = "El libro ya está prestado")
    @ApiResponse(responseCode = "404", description = "No se encontró el libro")
    //Prestar un libro
    @PostMapping("/{id}/prestar")
    public BookResponse loanBook(@PathVariable Long id) {
        
        
        return libraryService.setLoan(id);
    }
    

    @Operation(summary = "Actualizar un libro por id")
    @ApiResponse(responseCode = "200", description = "Libro actualizado")
    @ApiResponse(responseCode = "404", description = "No se encontró libro")
    @ApiResponse(responseCode = "400", description = "Los datos ingresados no son válidos")
    //Actualizar libro por id
    @PutMapping("/{id}")
    public BookResponse updateBook
        (
        @Valid    
        @PathVariable Long id, @RequestBody BookRequest book) {
        
        return libraryService.update(id, book);
    }


    @Operation(summary = "Borrar un libro por id")
    @ApiResponse(responseCode = "200", description = "Libro eliminado")
    @ApiResponse(responseCode = "404", description = "No se encontró libro")
    //Borrar libro por id
    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable Long id){
        libraryService.delete(id);
    }


    



    
}
