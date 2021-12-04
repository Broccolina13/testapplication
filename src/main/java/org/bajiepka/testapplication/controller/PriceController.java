package org.bajiepka.testapplication.controller;

import org.bajiepka.testapplication.dto.CreatePriceRequest;
import org.bajiepka.testapplication.dto.Price;
import org.bajiepka.testapplication.services.PriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Контроллер, который нужен для того, чтобы принимать запрос
 */
@RestController
@RequestMapping("${api.version}/price")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<Price> getPrices() {
        return priceService.getPrices();
    }
    @PostMapping
    public String addPrice(@RequestBody CreatePriceRequest dto) {
        return priceService.addPrice(dto);
    }
    @DeleteMapping
    public String deleteAllPrices(){
        return priceService.deletePrices();
    }
}


