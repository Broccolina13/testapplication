package org.bajiepka.testapplication.controller;

import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.bajiepka.testapplication.dto.abonent.CreateAbonentDTO;
import org.bajiepka.testapplication.entity.Abonent;
import org.bajiepka.testapplication.services.AbonentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version}/abonent")
public class AbonentController {

    private final AbonentService abonentService;

    public AbonentController(AbonentService abonentService) {
        this.abonentService = abonentService;
    }

    @Operation(summary = "Список абонентов", description = "Описание")
    @GetMapping
    public List<Abonent> getAbonents() {
        return abonentService.getAbonents();
    }

    @GetMapping("{id}")
    public List<Abonent> getAbonents(
            @PathVariable
            @Parameter(
                    name = "Уникальный идентификатор абонента",
                    example = "1000-2010"
            ) String id){
        return abonentService.getAbonents();
    }


    @PostMapping
    public String addAbonent(@RequestBody CreateAbonentDTO dto){
        return abonentService.createAbonent(dto);
    }
}


