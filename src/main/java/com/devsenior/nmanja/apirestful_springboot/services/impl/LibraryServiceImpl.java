package com.devsenior.nmanja.apirestful_springboot.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.apirestful_springboot.models.dto.BookRequest;
import com.devsenior.nmanja.apirestful_springboot.models.dto.BookResponse;
import com.devsenior.nmanja.apirestful_springboot.models.entities.Book;
import com.devsenior.nmanja.apirestful_springboot.repositories.LibraryRepository;
import com.devsenior.nmanja.apirestful_springboot.services.LibraryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class LibraryServiceImpl implements LibraryService{

    @Autowired
    public final LibraryRepository libraryRepository;

    @Override
    public List<BookResponse> getAll() {
        
        return libraryRepository.findAll().stream()
            .map(this::toResponse)
            .toList()
        ;
    }

    @Override
    public BookResponse create(BookRequest book) {
        
        var entity = toEntity(book); //Convertimos el dto en entity

        var newBook = libraryRepository.save(entity);  //en esta variable, procedemos a guardar la entidad con ayuda de la inyección del repositorio

        return toResponse(newBook); //para dar un response al cliente de que se guardaron los datos, convertimos la variable en tipoResponse
    }



    //En esta parte del servicio, pasamos los datos del entity al dto

    public BookResponse toResponse(Book book){

        var response = new BookResponse();

        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setIsbn(book.getIsbn());
        response.setReleaseDate(book.getReleaseDate());
        response.setGenre(book.getGenre());
        response.setState(book.getState());


        return response;
    }

    //En esta parte del servicio, pasamos los datos del dto a entity

    public Book toEntity(BookRequest book){

        var entity = new Book();

        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setIsbn(book.getIsbn());
        entity.setReleaseDate(book.getReleaseDate());
        entity.setGenre(book.getGenre());
        entity.setState(book.getState());

        return entity;

    }
    
}
