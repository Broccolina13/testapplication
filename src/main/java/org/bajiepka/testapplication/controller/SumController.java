package org.bajiepka.testapplication.controller;

import io.swagger.annotations.ApiOperation;
import org.bajiepka.testapplication.services.SumService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "Расчёт стоимости ЖКУ")
    @GetMapping
    public Integer calculateMeterSum(){
        return sumService.calculateMeterSum();
    }
}
