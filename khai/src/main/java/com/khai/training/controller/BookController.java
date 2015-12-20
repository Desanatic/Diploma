package com.khai.training.controller;


import com.khai.training.repository.BookRepository;
import com.khai.training.validation.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 7/16/2015.
 */
@Controller
public class BookController {

    private BookRepository bookRepository;
    private BookValidator bookValidator;

    @Autowired
    public BookController(BookRepository bookRepository, BookValidator bookValidator) {
        this.bookRepository = bookRepository;
        this.bookValidator = bookValidator;
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = this.bookRepository.listAll();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.GET)
    public String addBooks(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }


    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public String addBooks(@ModelAttribute("book") Book book, BindingResult bindingResult) {
        this.bookValidator.validate(book, bindingResult);
        this.bookRepository.addBook(book);
        if(bindingResult.hasErrors()){
            return "addBook";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBooks(@PathVariable Integer id) {
        this.bookRepository.removeBook(id);
        return "redirect:/";
    }*/
}
