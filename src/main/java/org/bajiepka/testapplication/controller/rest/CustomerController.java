package org.bajiepka.testapplication.controller.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.bajiepka.testapplication.dto.CreateCustomerRequest;
import org.bajiepka.testapplication.entity.Customer;
import org.bajiepka.testapplication.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.version}/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Список абонентов", produces = "application/json")
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @ApiOperation(value = "Получить список абонентов по id")
    @GetMapping("{id}")
    public List<Customer> getCustomers(
            @PathVariable
            @Parameter(
                    name = "Уникальный идентификатор абонента",
                    example = "1000-2010"
            ) String id){
        return customerService.getCustomers();
    }

    @ApiOperation(value = "Добавить нового абонента")
    @PostMapping
    public String addAbonent(@RequestBody CreateCustomerRequest dto){
        return customerService.createCustomer(dto);
    }
}


