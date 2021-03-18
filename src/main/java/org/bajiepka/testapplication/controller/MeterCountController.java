package org.bajiepka.testapplication.controller;

import org.bajiepka.testapplication.dto.meter.count.CreateMeterCountRequestDTO;
import org.bajiepka.testapplication.services.MeterCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("meter")
public class MeterCountController {

    @Autowired
    private MeterCountService meterCountService;

    //  REST - restful api
    //  ------------------
    //  GET - получение
    //  POST - создание
    //  PUT - изменение
    //  PATCH - изменение
    //  DELETE - удаление



    @GetMapping
    public List<CreateMeterCountRequestDTO> getAllCounts() {
        return meterCountService.getAllCount();
    }

    @PostMapping
    public String addNewMeterCount(@RequestBody CreateMeterCountRequestDTO dto) {
        return meterCountService.addNewMeterCount(dto);
    }

}
