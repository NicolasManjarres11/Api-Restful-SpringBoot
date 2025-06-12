package com.devsenior.nmanja.apirestful_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.apirestful_springboot.models.entities.Book;

public interface LibraryRepository extends JpaRepository<Book, Long>{
    

    
}
