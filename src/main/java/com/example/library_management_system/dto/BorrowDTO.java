package com.example.library_management_system.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowDTO {
    private Long userId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
