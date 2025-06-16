package com.devsenior.nmanja.apirestful_springboot.exceptions;

public class BookNotFoundById extends RuntimeException{

    public BookNotFoundById(String msg){
        super(msg);
    }

    public BookNotFoundById(Long id){
        super("Libro no encontrado con ID: "+id);
    }   
    
}
