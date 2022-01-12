package com.example.bookstore.controller;

import com.example.bookstore.bookDTO.BookStore;
import com.example.bookstore.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookStoreController {
    private final BookStoreService bookStoreService;

    @Autowired
    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping("home/book")
    public ResponseEntity<List<BookStore>> getAll() {
        List<BookStore> listBook = bookStoreService.getAll();
        return new ResponseEntity<>(listBook, HttpStatus.OK);
    }

    @GetMapping("/home/book/{id}")
    public ResponseEntity<BookStore> getBookById(@PathVariable("id") int id){
        BookStore bookStore = bookStoreService.getBookById(id);
        return new ResponseEntity<>(bookStore, HttpStatus.OK);
    }

    @PostMapping("/home/add")
    public ResponseEntity<BookStore> addBook(@RequestBody BookStore bookStore){
        BookStore bookStore1 = bookStoreService.addNewBook(bookStore);
        return new ResponseEntity<>(bookStore1, HttpStatus.CREATED);
    }

    @PutMapping("/home/update")
    public ResponseEntity<BookStore> updateBook(@RequestBody BookStore bookStore){
        BookStore updateBook = bookStoreService.updateBook(bookStore);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/home/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") int id){
        bookStoreService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
