package org.bajiepka.testapplication.controller.rest;

import org.bajiepka.testapplication.model.CurrencyItem;
import org.bajiepka.testapplication.services.ApiLayerCurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("currencies")
public class CurrencyController {

    private final ApiLayerCurrencyService apiLayerCurrencyService;

    public CurrencyController(ApiLayerCurrencyService apiLayerCurrencyService) {
        this.apiLayerCurrencyService = apiLayerCurrencyService;
    }

    @GetMapping
    public List<CurrencyItem> currencyItems() {
        return apiLayerCurrencyService.getCurrencies();
    }
}
