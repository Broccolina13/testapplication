package org.bajiepka.testapplication.controller.web;

import org.bajiepka.testapplication.model.VodaCrimeaLocation;
import org.bajiepka.testapplication.services.CurrencyService;
import org.bajiepka.testapplication.services.WaterTariffManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/index.html"})
public class HomeController {

    private final CurrencyService currencyService;
    private final WaterTariffManager waterTariffManager;
    private final static VodaCrimeaLocation DEFAULT_VODA_CRIMEA_LOCATION = VodaCrimeaLocation.KERCH;

    public HomeController(CurrencyService currencyService, WaterTariffManager waterTariffManager) {
        this.currencyService = currencyService;
        this.waterTariffManager = waterTariffManager;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("currencyData", currencyService.getCurrencies());
        model.addAttribute("waterItems", waterTariffManager.getItems(DEFAULT_VODA_CRIMEA_LOCATION));
        model.addAttribute("currencyRate", currencyService.getCurrencyRate());
        return "index";
    }
}

