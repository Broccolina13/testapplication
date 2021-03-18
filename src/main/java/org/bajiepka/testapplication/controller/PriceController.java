package org.bajiepka.testapplication.controller;

import org.bajiepka.testapplication.dto.price.CreatePriceRequestDTO;
import org.bajiepka.testapplication.dto.price.Price;
import org.bajiepka.testapplication.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Контроллер, который нужен для того, чтобы принимать запрос
 */
@RestController
@RequestMapping("price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public List<Price> getPrices() {
        return priceService.getPrices();
    }
    @PostMapping
    public String addPrice(@RequestBody CreatePriceRequestDTO dto) {
        return priceService.addPrice(dto);
    }
    @DeleteMapping
    public String deleteAllPrices(){
        return priceService.deletePrices();
    }
}


