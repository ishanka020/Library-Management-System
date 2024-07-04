package com.example.library_management_system.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class BookDTO {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    private String genre;
    private int quantity;
}
