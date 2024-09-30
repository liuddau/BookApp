package com.example.BookApp.repo;

import com.example.BookApp.model.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<List<Book>> findByTitleContainingIgnoreCase(String title);

    Optional<List<Book>> findByAuthorContainingIgnoreCase(String author);

    Optional<List<Book>> findByYearOfRelease(Integer yearOfRelease);

    Optional<List<Book>> findByRatingGreaterThanEqual(Double rating);

}