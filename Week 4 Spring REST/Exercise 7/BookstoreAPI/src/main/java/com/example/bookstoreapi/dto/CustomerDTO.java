package com.example.bookstoreapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    @JsonProperty("customer_id")
    // Getters and Setters
    private Long id;
    private String name;
    private String email;
    private String address;

}