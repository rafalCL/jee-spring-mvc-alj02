package pl.coderslab.jeespringmvcalj02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.jeespringmvcalj02.Book;


@RestController
@RequestMapping("/jackson")
public class JacksonController {
    @GetMapping("/getbook")
    public Book getBook() {
        return new Book("Potop", "Sienkiewicz");
    }
}
