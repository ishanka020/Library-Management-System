package com.example.library_management_system.repo;

import com.example.library_management_system.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
}
