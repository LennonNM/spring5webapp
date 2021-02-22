package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Makes this class into Spring MVC controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository; // to link to the repository
    }

    @RequestMapping("/books") // maps getBooks to http -> url/books
    public String getBooks(Model model) { // a copy of the model is what's returned to the view

        model.addAttribute("books", bookRepository.findAll()); // maps the model to the attribute books, and
                                        // provides all data in bookRepository to that model, so that the view can
                                        // use it

        return "books/list"; // View name -> looks under templates.books.list.html
    }
}
