package org.bajiepka.testapplication.controller.rest;

import org.bajiepka.testapplication.services.SumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/sum")
public class SumController {

    private final SumService sumService;

    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @GetMapping
    public Integer calculateMeterSum(){
        return sumService.calculateMeterSum();
    }
}
