package com.example.library_management_system.service;

import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.repo.BookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepository;
    @Autowired
    private ModelMapper modelMapper;
    public BookDTO addBook(BookDTO bookDto) {
         bookRepository.save(modelMapper.map(bookDto, Book.class));
         return bookDto;
    }

    public Book updateBook(Long bookId, BookDTO bookDto) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }

    public Book getBookDetails(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public Boolean checkBookAvailability(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return true;
    }
}
