package org.bajiepka.testapplication.controller;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Перечень тарифов")
    @GetMapping
    public List<Price> getPrices() {
        return priceService.getPrices();
    }

    @ApiOperation(value = "Заполнить тариф")
    @PostMapping
    public String addPrice(@RequestBody CreatePriceRequest dto) {
        return priceService.addPrice(dto);
    }

    @ApiOperation(value = "Очистить тарифы")
    @DeleteMapping
    public String deleteAllPrices(){
        return priceService.deletePrices();
    }
}


