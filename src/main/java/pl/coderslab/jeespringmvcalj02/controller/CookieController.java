package pl.coderslab.jeespringmvcalj02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

// Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz kontroller CookieController oraz trzy akcje dostępne pod adresami setCookie, showCookie, deleteCookie.
//Akcja pod adresem /setCookie ma nastawiać ciasteczko o nazwie User na CodersLab, z ważnością 24h.
//Akcja pod adresem /showCookie. Ma wyświetlać zawartość ciasteczka User.
//Akcja pod adresem /deleteCookie ma kasować ciasteczko o nazwie User. Jeżeli nie ma takiego ciasteczka, to powinien wyświetlić się napis: BRAK.

@Controller
@RequestMapping("/cookie")
public class CookieController {
    @GetMapping("/setCookie")
    @ResponseBody
    public String setCookie(HttpServletResponse response) {
        Cookie c = new Cookie("User", "CodersLab");
        c.setMaxAge(24 * 60 * 60);
        c.setPath("/");

        response.addCookie(c);

        return "ciasteczko ustawione, zobacz w dev tools!";
    }

    @GetMapping("/showCookie")
    @ResponseBody
    public String showCookie(HttpServletRequest request) {
        Cookie user = WebUtils.getCookie(request, "User");
        if(user != null) {
            return "ciasteczko odczytane, User=" + user;
        }
//        Cookie[] cookies = request.getCookies();
//
//        for(Cookie c : cookies) {
//            if(c.getName().equals("User")) {
//                return "ciasteczko odczytane, User=" + c.getValue();
//            }
//        }

        return "brak ciasteczka";
    }

    @GetMapping("/showCookie2")
    @ResponseBody
    public String showCookie(@CookieValue(value = "User", required = false) String user) {
        if(user != null) {
            return "ciasteczko odczytane, User=" + user;
        }
        return "brak ciasteczka";
    }

    @GetMapping("/deleteCookie")
    @ResponseBody
    public String deleteCookie(HttpServletResponse response) {
        Cookie c = new Cookie("User", "");
        c.setMaxAge(0);
        c.setPath("/");

        response.addCookie(c);

        return "ciasteczko usunięte, zobacz w dev tools!";
    }

    @PostMapping("/addToCookies")
    @ResponseBody
    public String addToCookies(@RequestParam String key, @RequestParam String value, HttpServletResponse response) {
        Cookie c = new Cookie(key, value);
        c.setMaxAge(24 * 60 * 60);
        c.setPath("/");

        response.addCookie(c);

        return "ciasteczko dodane";
    }
}
