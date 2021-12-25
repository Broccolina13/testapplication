package org.bajiepka.testapplication.controller.web;

import org.bajiepka.testapplication.model.VodaCrimeaLocation;
import org.bajiepka.testapplication.services.ApiLayerCurrencyService;
import org.bajiepka.testapplication.services.WaterTariffManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/index.html"})
public class HomeController {

    private final ApiLayerCurrencyService apiLayerCurrencyService;
    private final WaterTariffManager waterTariffManager;
    private final static VodaCrimeaLocation DEFAULT_VODA_CRIMEA_LOCATION = VodaCrimeaLocation.KERCH;

    public HomeController(ApiLayerCurrencyService apiLayerCurrencyService, WaterTariffManager waterTariffManager) {
        this.apiLayerCurrencyService = apiLayerCurrencyService;
        this.waterTariffManager = waterTariffManager;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("currencyData", apiLayerCurrencyService.getCurrencies());
        model.addAttribute("waterItems", waterTariffManager.getItems(DEFAULT_VODA_CRIMEA_LOCATION));
        model.addAttribute("currencyRate", apiLayerCurrencyService.getCurrencyRate());
        return "index";
    }
}

