package pl.coderslab.jeespringmvcalj02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping(path = "/encoding", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String start() {
        return "<h1>title</h1> <p>  łóąś</p>";
    }

    @GetMapping("/helloParam")
    @ResponseBody
    private String helloParam(HttpServletRequest request) {
        String paramValue = request.getParameter("name");
        System.out.println(paramValue);
        return "My param = " + paramValue;
    }

    @GetMapping("/helloParam2")
    @ResponseBody
    private String helloParam2(@RequestParam("age") String ageVal,
                               @RequestParam("name") String nameVal) {
        System.out.println(ageVal);
        return "My param = " + ageVal;
    }

    @GetMapping("/helloParam3")
    @ResponseBody
    private String helloParam3(@RequestParam int age,
                               @RequestParam String name) {
        System.out.println(age);
        return "My param = " + name;
    }

    @RequestMapping("/pathvar/{max}/{count}/{name}")
    @ResponseBody
    private String requestParamsUri(@PathVariable long max,
                                    @PathVariable int count,
                                    @PathVariable String name) {
        return "My count = " + count + " My max = " + max+ " My name = " + name;
    }

    @GetMapping("/userAgent")
    @ResponseBody
    public String userAgent(@RequestHeader("user-agent") String userAgent) {
        return "user-agent = "  + userAgent;
    }
}
