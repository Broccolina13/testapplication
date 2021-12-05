package org.bajiepka.testapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.bajiepka.testapplication.dto.CreateCustomerRequest;
import org.bajiepka.testapplication.entity.Customer;
import org.bajiepka.testapplication.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version}/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Список абонентов", description = "Описание")
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{id}")
    public List<Customer> getCustomers(
            @PathVariable
            @Parameter(
                    name = "Уникальный идентификатор абонента",
                    example = "1000-2010"
            ) String id){
        return customerService.getCustomers();
    }

    @PostMapping
    public String addAbonent(@RequestBody CreateCustomerRequest dto){
        return customerService.createAbonent(dto);
    }
}


