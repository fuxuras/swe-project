package com.swe.libary_project.controller;

import com.swe.libary_project.entities.Book;
import com.swe.libary_project.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookService bookService;

    @GetMapping("/")
    public String homePage(Model model) {
        // Fetch featured books (limit to 5 for homepage)
        List<Book> featuredBooks = bookService.getAllBooks().stream()
                .limit(5)
                .toList();
        model.addAttribute("featuredBooks", featuredBooks);
        return "index";
    }
}
