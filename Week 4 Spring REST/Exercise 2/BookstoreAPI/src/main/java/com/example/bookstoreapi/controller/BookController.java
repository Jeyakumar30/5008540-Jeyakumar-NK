package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Sample data
    public BookController() {
        books.add(new Book(1L, "Effective Java", "Joshua Bloch", 45.0, "9013468578991"));
        books.add(new Book(2L, "Clean Code", "Robert C. Martin", 40.0, "9508780132384"));
    }

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET a single book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // PUT to update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book;
            }
        }
        return null;
    }

    // DELETE a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}