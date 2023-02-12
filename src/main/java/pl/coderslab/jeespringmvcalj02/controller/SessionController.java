package pl.coderslab.jeespringmvcalj02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

// W projekcie stwórz trzy akcje:
//
///session1Set,
///session1Get ,
///session1Del.
//Pierwsza ma ustawiać atrybut sesji pod kluczem counter na 0.
//Druga ma wyświetlać zawartość sesji pod kluczem counter i zwiększać go o 1. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić informację: EMPTY.
//Trzecia ma usuwać dane z sesji (tylko te trzymane pod kluczem counter).

@Controller
@RequestMapping("/session")
public class SessionController {
    @GetMapping("/session1Set")
    @ResponseBody
    public String session1Set(HttpServletRequest request) {
        //Pierwsza ma ustawiać atrybut sesji pod kluczem counter na 0.
        HttpSession session = request.getSession();
        session.setAttribute("counter", 0);

        return "sesja zainicjowana";
    }

    @GetMapping("/session1Get")
    @ResponseBody
    public String session1Get(HttpServletRequest request) {
        //Druga ma wyświetlać zawartość sesji pod kluczem counter i zwiększać go o 1.
        // Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić informację: EMPTY.
        HttpSession session = request.getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter != null) {
            session.setAttribute("counter", counter + 1);
            return "counter="+counter;
        }

        return "EMPTY";
    }

    @GetMapping("/session1Del")
    @ResponseBody
    public String session1Del(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("counter");

        return "counter usunięty z sesji";
    }

    @PostMapping("/addToSession")
    @ResponseBody
    public String addToSession(@RequestParam int grade, HttpServletRequest request) {
        HttpSession session = request.getSession();

        List<Integer> grades = (List<Integer>)session.getAttribute("grades");

        if (grades == null) {
            grades = new ArrayList<>();
        }

        grades.add(grade);
        session.setAttribute("grades", grades);

        double avg = calculateAvg(grades);

        return String.format("grades=%s, avg=%s", grades, avg);
    }

    private static double calculateAvg(List<Integer> grades) {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0.0);
    }
}
