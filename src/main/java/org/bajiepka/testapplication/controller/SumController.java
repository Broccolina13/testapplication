package org.bajiepka.testapplication.controller;

import org.bajiepka.testapplication.services.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sum")
public class SumController {

    @Autowired
    private SumService sumService;

    //  Метод, который возвращает сумму стоимости по показания (показание * цену)
    @GetMapping
    public Integer calculateMeterSum(){
        return sumService.calculateMeterSum();
    }
}
