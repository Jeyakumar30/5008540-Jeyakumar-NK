package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query methods (if any) can be added here
}