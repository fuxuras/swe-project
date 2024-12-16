package com.swe.libary_project.services;

import com.swe.libary_project.entities.Book;
import com.swe.libary_project.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Tüm kitapları listele
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ID'ye göre kitap getir
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Yeni kitap ekle
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Kitabı güncelle
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(updatedBook.getTitle());
                    existingBook.setAuthor(updatedBook.getAuthor());
                    existingBook.setGenre(updatedBook.getGenre());
                    existingBook.setStatus(updatedBook.getStatus());
                    existingBook.setSynopsis(updatedBook.getSynopsis());
                    existingBook.setPublicationDate(updatedBook.getPublicationDate());
                    return bookRepository.save(existingBook);
                }).orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    // ID'ye göre kitap sil
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Türüne (genre) göre kitapları getir
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    // Başlığa göre kelime araması yap
    public List<Book> searchBooksByTitle(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    // Durumuna göre kitapları listele (Available, Borrowed, Reserved)
    public List<Book> getBooksByStatus(String status) {
        return bookRepository.findByStatus(status);
    }
}
