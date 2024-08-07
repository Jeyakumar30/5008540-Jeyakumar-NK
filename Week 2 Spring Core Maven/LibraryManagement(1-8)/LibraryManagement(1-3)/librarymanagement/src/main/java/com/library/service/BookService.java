package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Adding a book
    public void addBook(String title) {
        bookRepository.saveBook(title);
    }

    // Retrieving all the books
    public void getAllBooks() {
        bookRepository.findAllBooks();
    }
}