package com.example.bookstore.service;

import com.example.bookstore.bookDTO.BookStore;
import com.example.bookstore.exception.UserNotFoundException;
import com.example.bookstore.reposiory.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    @Autowired
    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public BookStore addNewBook(BookStore bookStore) {
        return bookStoreRepository.save(bookStore);
    }
    public List<BookStore> getAll() {
        return bookStoreRepository.findAll();
    }

    public BookStore getBookById(int id){
        return bookStoreRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public BookStore updateBook(BookStore bookStore){
        return bookStoreRepository.save(bookStore);
    }

    public void deleteBook(int id){
        bookStoreRepository.deleteById(id);
    }
}
