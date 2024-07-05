package com.example.library_management_system.service;

import com.example.library_management_system.dto.BorrowDTO;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.entity.Borrow;
import com.example.library_management_system.entity.User;
import com.example.library_management_system.repo.BookRepo;
import com.example.library_management_system.repo.BorrowRepo;
import com.example.library_management_system.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {
    @Autowired
    public BorrowRepo borrowRepo;
    @Autowired
    public UserRepo userRepo;
    @Autowired
    public BookRepo bookRepo;
    @Autowired
    public ModelMapper modelMapper;

    public Borrow addBorrow(BorrowDTO borrowDto) {
        User user = userRepo.findById(borrowDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepo.findById(borrowDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));


        return borrowRepo.save(modelMapper.map(borrowDto, Borrow.class));
    }

    public Borrow updateBorrow(Long borrowId, BorrowDTO borrowDto) {
        Borrow borrow = borrowRepo.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        User user = userRepo.findById(borrowDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepo.findById(borrowDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return borrowRepo.save(borrow);
    }

    public void deleteBorrow(Long borrowId) {
        Borrow borrow = borrowRepo.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
        borrowRepo.delete(borrow);
    }

    public Borrow getBorrowDetails(Long borrowId) {
        return borrowRepo.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
    }

    public List<Borrow> listAllBorrows() {
        return borrowRepo.findAll();
    }

    public List<Borrow> listBorrowsByUserId(Long userId) {
        return borrowRepo.findByUserId(userId);
    }

    public List<Borrow> listBorrowsByBookId(Long bookId) {
        return borrowRepo.findByBookId(bookId);
    }


}
