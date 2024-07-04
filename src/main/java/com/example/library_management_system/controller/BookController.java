package com.example.library_management_system.controller;

import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.service.BookService;
import com.example.library_management_system.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {
    @Autowired
    public BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDto) {
        return ResponseEntity.ok(bookService.addBook(bookDto));
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody BookDTO bookDto) {
        return ResponseEntity.ok(bookService.updateBook(bookId, bookDto));
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookDetails(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getBookDetails(bookId));
    }

    @GetMapping
    public ResponseEntity<List<Book>> listAllBooks() {
        return ResponseEntity.ok(bookService.listAllBooks());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String title) {
        return ResponseEntity.ok(bookService.searchBooks(title));
    }

    @GetMapping("/{bookId}/availability")
    public ResponseEntity<Boolean> checkBookAvailability(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.checkBookAvailability(bookId));
    }

}
