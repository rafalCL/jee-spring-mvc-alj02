package pl.coderslab.jeespringmvcalj02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("")
    @ResponseBody
    public String mainPage() {
        return "main page of our app";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "hello from spring web mvc";
    }
}
