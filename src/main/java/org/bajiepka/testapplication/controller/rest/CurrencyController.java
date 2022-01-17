package org.bajiepka.testapplication.controller.rest;

import org.bajiepka.testapplication.model.CurrencyItem;
import org.bajiepka.testapplication.services.currate.CurrateCurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("currencies")
public class CurrencyController {

    private final CurrateCurrencyService currateCurrencyService;

    public CurrencyController(CurrateCurrencyService currateCurrencyService) {
        this.currateCurrencyService = currateCurrencyService;
    }

    @GetMapping
    public List<CurrencyItem> currencyItems() {
        return currateCurrencyService.getCurrencies();
    }
}
