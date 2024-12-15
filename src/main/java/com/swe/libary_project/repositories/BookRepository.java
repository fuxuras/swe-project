package com.swe.libary_project.repositories;

import com.swe.libary_project.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // sort by genre
    List<Book> findByGenre(String genre);

    // search for a certain word
    List<Book> findByTitleContaining(String keyword);

    // list books by status at that time such as available etc.
    List<Book> findByStatus(String status);
}
