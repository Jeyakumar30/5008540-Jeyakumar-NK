package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/books")
public class BookController {

    private static List<Book> books = new ArrayList<>();

    // Sample data
    public BookController() {
        books.add(new Book(1L, "Effective Java", "Joshua Bloch", 45.0, "9780134685991"));
        books.add(new Book(2L, "Clean Code", "Robert C. Martin", 40.0, "9780132350884"));
    }

    // GET all books with custom header
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Book-Count", String.valueOf(books.size()));
        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }

    // GET a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            throw new BookNotFoundException(id);
        }
    }

    // POST a new book with status 201 Created
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // PUT to update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return new ResponseEntity<>(book, HttpStatus.OK);
            }
        }
        throw new BookNotFoundException(id);
    }

    // DELETE a book by ID with status 204 No Content
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class BookNotFoundException extends RuntimeException {
        public BookNotFoundException(Long id) {
            super("Book with ID " + id + " not found.");
        }

        @GetMapping("/search")
        public List<Book> searchBooks(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String author) {
            return books.stream()
                    .filter(book -> (title == null || book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                            (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase())))
                    .collect(Collectors.toList());
        }

    }
}