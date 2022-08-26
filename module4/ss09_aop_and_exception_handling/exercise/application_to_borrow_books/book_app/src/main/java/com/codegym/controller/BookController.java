package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Library;
import com.codegym.service.IBookService;
import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private ILibraryService libraryService;

    @GetMapping(value = "")
    public String findAll(Model model, @RequestParam Optional<String> keyword) {
        String keyWord = keyword.orElse("");

        model.addAttribute("books", bookService.findAll());
        model.addAttribute("keyword", keyWord);
        return "/list";
    }

    @GetMapping("/{id}/detail")
    public String viewBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "/detail";
    }

    @PostMapping(value = "/edit")
    public String update(Book book) throws Exception {
        bookService.save(book);
        Long rentalCode = (long) Math.floor(Math.random() * 89999) + 10000;
        Optional<Book> bookOptional = bookService.findById(book.getId());
        if (bookOptional.get().getQuantity() <= 0) {
            throw new Exception();
        } else {
            libraryService.save(new Library(rentalCode, book));
        }
        return "redirect:/book";
    }

    @PostMapping(value = "/pay")
    public String payBook(@RequestParam Long rentalCode) throws NullPointerException {
        Optional<Library> library = libraryService.findByRentalCode(rentalCode);
        if (library.get().getId() == null) {
            throw new NullPointerException();
        } else {
            Optional<Book> book = bookService.findById(library.get().getBook().getId());
            book.get().setQuantity(book.get().getQuantity() + 1);
            libraryService.remove(library.get().getId());
        }
        return "redirect:/book";
    }

    @ExceptionHandler(value = Exception.class)
    public String goBookError() {
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public String goError() {
        return "error2";
    }
}
