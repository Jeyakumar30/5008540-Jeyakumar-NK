package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<String> books = new ArrayList<>();
    private int nextId = 1;

    public void addBook(String title) {
        books.add(nextId++ + ": " + title);
    }

    public List<String> getAllBooks() {
        return books;
    }

    public String getBookById(int id) {
        for (String book : books) {
            if (book.startsWith(id + ":")) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(int id, String newTitle) {
        String book = getBookById(id);
        if (book != null) {
            int index = books.indexOf(book);
            books.set(index, id + ": " + newTitle);
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.startsWith(id + ":"));
    }
}