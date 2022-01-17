package org.bajiepka.testapplication.repository;

import org.bajiepka.testapplication.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getAbonentById() {
        return customers;
    }

    public String save(Customer customer) {
        customer.setId(String.valueOf(customers.size()));
        customers.add(customer);
        return customer.getId();
    }


}
