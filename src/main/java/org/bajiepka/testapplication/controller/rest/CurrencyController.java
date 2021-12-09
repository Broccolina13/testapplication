package org.bajiepka.testapplication.controller.rest;

import org.bajiepka.testapplication.model.CurrencyItem;
import org.bajiepka.testapplication.services.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public List<CurrencyItem> currencyItems() {
        return currencyService.getCurrencies();
    }
}
