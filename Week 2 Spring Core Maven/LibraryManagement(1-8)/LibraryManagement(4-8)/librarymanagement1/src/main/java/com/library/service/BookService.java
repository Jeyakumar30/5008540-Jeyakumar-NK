package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Constructor for constructor injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter for setter injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        bookRepository.addBook(bookName);
    }

    public List<String> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public String getBookById(int id) {
        return bookRepository.getBookById(id);
    }

    public void updateBook(int id, String newTitle) {
        bookRepository.updateBook(id, newTitle);
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }
}