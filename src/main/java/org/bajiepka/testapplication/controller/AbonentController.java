package org.bajiepka.testapplication.controller;

import org.bajiepka.testapplication.dto.abonent.CreateAbonentDTO;
import org.bajiepka.testapplication.entity.Abonent;
import org.bajiepka.testapplication.services.AbonentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("abonent")
public class AbonentController {

    @Autowired
    private AbonentService abonentService;

    //  TODO реализовать get метод, который получит из постмана айдишку и запросит по ней абонента в сервисе
    @GetMapping
    public List<Abonent> getAbonentById() {
        return abonentService.getAbonentListById();
    }

    @GetMapping("{id}")
    public List<Abonent> getAbonentById(@PathVariable String id){
        return abonentService.getAbonentListById();
//                .filter(abonentService -> abonentService.get("id").equals(id))
//                .findFirst();
    }


    @PostMapping
    public String addAbonent(@RequestBody CreateAbonentDTO dto){
        return abonentService.createAbonent(dto);
    }
}


