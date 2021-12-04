package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.dto.CreateCustomerRequest;
import org.bajiepka.testapplication.entity.Customer;
import org.bajiepka.testapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //  TODO реализовать метод, который будет получать из репозитория абонента по коду
    public List<Customer> getCustomers() {
        return customerRepository.getAbonentById();
    }

    public String createAbonent(CreateCustomerRequest dto){

        Customer customer = new Customer("",
                dto.name(),
                dto.lastName(),
                Integer.parseInt(dto.clientAge()),
                0L);
        return customerRepository.save(customer);
    }

}
