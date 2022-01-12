package com.example.bookstore.reposiory;

import com.example.bookstore.bookDTO.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<BookStore, Integer> {
}
