package pl.coderslab.jeespringmvcalj02.controller;

// Zadanie 1 - rozwiązywane z wykładowcą
//Utwórz akcję dostępną pod pod adresem /random/{max} gdzie max będzie górną granicą zbioru z którego zostanie wylosowana liczba.
//Wylosuj wartość od 1 do max.
//Wyświetl w przeglądarce dane w następujący sposób: Użytkownik podał wartość max. Wylosowano liczbę: wylosowana liczba.

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/random")
public class RandomController {
    @GetMapping("/{max}")
    @ResponseBody
    public String getRandom(@PathVariable int max) {
        Random random = new Random(System.nanoTime());
        return String.format("Użytkownik podał wartość %s. Wylosowano liczbę: %s", max, random.nextInt(max) + 1);
    }

    @GetMapping("/{min}/{max}")
    @ResponseBody
    public String getRandom2(@PathVariable int min, @PathVariable int max) {
        Random random = new Random(System.nanoTime());
        return String.format("Użytkownik podał wartości %s i %s. Wylosowano liczbę: %s", min, max, min + random.nextInt(max-min + 1));
    }
}
