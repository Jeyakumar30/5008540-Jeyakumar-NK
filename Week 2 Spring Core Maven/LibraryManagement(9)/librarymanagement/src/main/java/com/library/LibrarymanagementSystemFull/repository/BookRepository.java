package com.library.LibrarymanagementSystemFull.repository;

import com.library.LibrarymanagementSystemFull.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
