package com.swe.libary_project.controller;

import com.swe.libary_project.entities.Book;
import com.swe.libary_project.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Tüm kitapları listele
    @GetMapping("")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books); // HTML sayfasına kitapları gönder
        return "books"; // Thymeleaf template adı: books.html
    }

    // ID'ye göre kitap detayını göster
    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
        model.addAttribute("book", book);
        return "book-detail"; // Thymeleaf template adı: book-detail.html
    }

    // Yeni kitap ekleme sayfasını göster
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book"; // Thymeleaf template adı: add-book.html
    }

    // Yeni kitap ekle
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books"; // Ekleme sonrası kitap listesine yönlendir
    }

    // Kitap güncelleme sayfasını göster
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
        model.addAttribute("book", book);
        return "edit-book"; // Thymeleaf template adı: edit-book.html
    }

    // Kitabı güncelle
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return "redirect:/books";
    }

    // Kitabı sil
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    // Türüne (genre) göre kitapları listele
    @GetMapping("/genre/{genre}")
    public String getBooksByGenre(@PathVariable String genre, Model model) {
        List<Book> books = bookService.getBooksByGenre(genre);
        model.addAttribute("books", books);
        return "books"; // Aynı template kitap listesini gösterecek
    }

    // Başlığa göre arama yap
    @GetMapping("/search")
    public String searchBooks(@RequestParam String keyword, Model model) {
        List<Book> books = bookService.searchBooksByTitle(keyword);
        model.addAttribute("books", books);
        return "books";
    }

    // Durumuna göre kitapları listele
    @GetMapping("/status/{status}")
    public String getBooksByStatus(@PathVariable String status, Model model) {
        List<Book> books = bookService.getBooksByStatus(status);
        model.addAttribute("books", books);
        return "books";
    }
}
