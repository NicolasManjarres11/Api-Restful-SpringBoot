package com.devsenior.nmanja.apirestful_springboot.services;

import java.util.List;

import com.devsenior.nmanja.apirestful_springboot.models.dto.BookRequest;
import com.devsenior.nmanja.apirestful_springboot.models.dto.BookResponse;
import com.devsenior.nmanja.apirestful_springboot.models.entities.Book;

//Capa de servicios

public interface LibraryService{

    List<BookResponse> getAll(); //Trae todos los libres
    BookResponse getBookById(Long id);
    BookResponse create(BookRequest book); //Crea un libro
    BookResponse update(Long id, BookRequest book); //Actualiza un libro, buscandolo por id
    void delete(Long id); //Elimina un libro buscado por id
    List<BookResponse> getBooksByTitleOrAuthor(String searchTerm);
    BookResponse setLoan(Long id);
    
}
