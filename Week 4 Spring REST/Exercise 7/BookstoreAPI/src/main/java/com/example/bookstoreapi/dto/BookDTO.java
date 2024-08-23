package com.example.bookstoreapi.dto;


import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Setter
@Getter
public class BookDTO {
    @JsonProperty("book_id")
    // Getters and Setters
    private Long id;
    private String title;
    private String author;
    private Double price;
    private String isbn;
}