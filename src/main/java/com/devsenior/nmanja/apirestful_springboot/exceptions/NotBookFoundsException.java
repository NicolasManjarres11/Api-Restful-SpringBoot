package com.devsenior.nmanja.apirestful_springboot.exceptions;

//Excepcion para libros no encontrados por titulo o por autor

public class NotBookFoundsException extends RuntimeException{

    public NotBookFoundsException(String msg){
        super(msg);
    }

    
}
