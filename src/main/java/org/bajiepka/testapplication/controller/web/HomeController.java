package org.bajiepka.testapplication.controller.web;

import org.bajiepka.testapplication.model.VodaCrimeaLocation;
import org.bajiepka.testapplication.services.CurrencyService;
import org.bajiepka.testapplication.services.WaterParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/index.html"})
public class HomeController {

    private final CurrencyService currencyService;
    private final WaterParser waterParser;
    private final static VodaCrimeaLocation DEFAULT_VODA_CRIMEA_LOCATION = VodaCrimeaLocation.KERCH;

    public HomeController(CurrencyService currencyService, WaterParser waterParser) {
        this.currencyService = currencyService;
        this.waterParser = waterParser;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("currencyData", currencyService.getCurrencies());
        model.addAttribute("waterData", waterParser.parseWater(DEFAULT_VODA_CRIMEA_LOCATION));
        return "index";
    }
}

