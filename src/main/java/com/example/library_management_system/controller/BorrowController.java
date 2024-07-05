package com.example.library_management_system.controller;

import com.example.library_management_system.dto.BorrowDTO;
import com.example.library_management_system.entity.Borrow;
import com.example.library_management_system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public ResponseEntity<Borrow> addBorrow(@RequestBody BorrowDTO borrowDto) {
        return ResponseEntity.ok(borrowService.addBorrow(borrowDto));
    }

    @PutMapping("/{borrowId}")
    public ResponseEntity<Borrow> updateBorrow(@PathVariable Long borrowId, @RequestBody BorrowDTO borrowDto) {
        return ResponseEntity.ok(borrowService.updateBorrow(borrowId, borrowDto));
    }

    @DeleteMapping("/{borrowId}")
    public ResponseEntity<String> deleteBorrow(@PathVariable Long borrowId) {
        borrowService.deleteBorrow(borrowId);
        return ResponseEntity.ok("Borrow record deleted successfully");
    }

    @GetMapping("/{borrowId}")
    public ResponseEntity<Borrow> getBorrowDetails(@PathVariable Long borrowId) {
        return ResponseEntity.ok(borrowService.getBorrowDetails(borrowId));
    }

    @GetMapping
    public ResponseEntity<List<Borrow>> listAllBorrows() {
        return ResponseEntity.ok(borrowService.listAllBorrows());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Borrow>> listBorrowsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(borrowService.listBorrowsByUserId(userId));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Borrow>> listBorrowsByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(borrowService.listBorrowsByBookId(bookId));
    }
}
