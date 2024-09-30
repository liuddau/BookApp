package com.example.BookApp.controller;

import com.example.BookApp.model.Book;
import com.example.BookApp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRepository.findAll().forEach(bookList::add);

            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        try {
            Optional<Book> bookObj = bookRepository.findById(id);
            if (bookObj.isPresent()) {
                return new ResponseEntity<>(bookObj.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookByTitle/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        try {
            Optional<List<Book>> bookObj = bookRepository.findByTitleContainingIgnoreCase(title);
            if (bookObj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookObj.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookYearOfRelease/{year}")
    public ResponseEntity<List<Book>> getBookYearOfRelease(@PathVariable Integer year) {
        try {
            Optional<List<Book>> bookObj = bookRepository.findByYearOfRelease(year);
            if (bookObj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookObj.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookByAuthor/{author}")
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String author) {
        try {
            Optional<List<Book>> bookObj = bookRepository.findByAuthorContainingIgnoreCase(author);
            if (bookObj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookObj.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBookByRating/{rating}")
    public ResponseEntity<List<Book>> getBookByRating(@PathVariable Double rating) {
        try {
            Optional<List<Book>> bookObj = bookRepository.findByRatingGreaterThanEqual(rating);
            if (bookObj.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookObj.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
