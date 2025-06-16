package com.devsenior.nmanja.apirestful_springboot.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsenior.nmanja.apirestful_springboot.exceptions.BookAlreadyLentException;
import com.devsenior.nmanja.apirestful_springboot.exceptions.BookNotFoundById;
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

    //Servicio para obtener todos los libros utilizando los metodos inyectados por el repositorio

    @Override
    public List<BookResponse> getAll() {
        
        return libraryRepository.findAll().stream()
            .map(this::toResponse)
            .toList()
        ;
    }

    //Servicio para obtener libro por Id

    @Override
    public BookResponse getBookById(Long id) {       

        return libraryRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BookNotFoundById(id));
    }

    //Servicio para crear un nuevo libro

    @Override
    public BookResponse create(BookRequest book) {
        
        var entity = toEntity(book); //Convertimos el dto en entity

        var newBook = libraryRepository.save(entity);  //en esta variable, procedemos a guardar la entidad con ayuda de la inyección del repositorio

        return toResponse(newBook); //para dar un response al cliente de que se guardaron los datos, convertimos la variable en tipoResponse
    }

    //Servicio para actualizar un libro por id

    @Override
    public BookResponse update(Long id, BookRequest book) {

        var entityOptional = libraryRepository.findById(id);

        if(!entityOptional.isPresent()){ //Si la entidad buscada por el id no está presente, lance la excepción
            throw new BookNotFoundById(id);
        }                                   //De lo contrario, pase a entidad el requeste enviado y actualice segun el id la informacion

        var entity = toEntity(book);
        entity.setId(entityOptional.get().getId());

        var updatedEntity = libraryRepository.save(entity);
        
        return toResponse(updatedEntity);
    }

    //Servicio para borrar un libro por id

    @Override
    public void delete(Long id) {

        libraryRepository.deleteById(id);

    }

    //Servicio para buscar un libro por titulo o autor

    @Override
    public List<BookResponse> getBooksByTitleOrAuthor(String searchTerm) {

        if(searchTerm == null || searchTerm.trim().isEmpty()){
            return new ArrayList<>();
        }

        return libraryRepository.searchBooks(searchTerm).stream()
                .map(this::toResponse)
                .toList();


    }

    //Servidio para prestar un libro

    @Override
    public BookResponse setLoan(Long id) {

        var book = libraryRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundById(id));

        if(book.getState().equals("PRESTADO")){
            throw new BookAlreadyLentException(id);
        }

        book.setState("PRESTADO");
        var updateBook = libraryRepository.save(book);

        return toResponse(updateBook);
        
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

    //En esta parte del servicio, pasamos los datos del dto al entity

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
