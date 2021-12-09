package org.bajiepka.testapplication.controller.web;

import org.bajiepka.testapplication.services.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/index.html"})
public class HomeController {

    private final CurrencyService currencyService;

    public HomeController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("currencyData", currencyService.getCurrencies());
        return "index";
    }
}

