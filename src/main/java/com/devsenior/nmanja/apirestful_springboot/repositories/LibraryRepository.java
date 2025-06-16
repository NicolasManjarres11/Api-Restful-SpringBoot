package com.devsenior.nmanja.apirestful_springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsenior.nmanja.apirestful_springboot.models.entities.Book;

public interface LibraryRepository extends JpaRepository<Book, Long>{
    

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(b.author) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Book> searchBooks(@Param("searchTerm") String searchTerm);
    
}
