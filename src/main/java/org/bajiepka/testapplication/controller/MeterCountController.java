package org.bajiepka.testapplication.controller;

import org.bajiepka.testapplication.dto.CreateMeterRequest;
import org.bajiepka.testapplication.services.MeterCountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.version}/meter")
public class MeterCountController {

    private final MeterCountService meterCountService;

    public MeterCountController(MeterCountService meterCountService) {
        this.meterCountService = meterCountService;
    }

    @GetMapping
    public List<CreateMeterRequest> getAllCounts() {
        return meterCountService.getAllCount();
    }

    @PostMapping
    public String addNewMeterCount(@RequestBody CreateMeterRequest dto) {
        return meterCountService.addNewMeterCount(dto);
    }
}
