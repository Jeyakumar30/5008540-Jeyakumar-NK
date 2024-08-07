package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<String> books = new ArrayList<>();

    // Saving a book
    public void saveBook(String title) {
        books.add(title);
        System.out.println("\"" + title + "\"" + " book successfully loaded to the system.");
    }

    // Retrieving all the books
    public void findAllBooks() {
        System.out.println("Fetching all the books\n----------------------");
        int count = 1;
        for (String book : books) {
            System.out.println("Book " + count + ": " + book);
            count++;
        }
    }
}