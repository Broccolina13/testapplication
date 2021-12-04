package org.bajiepka.testapplication.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void adressTest(){
        Customer customer = new Customer("", "", "", 0,null);
        List<String> expectedAddresses = customer.getAddresses();
        assertNull(expectedAddresses);
    }
    @Test
    public void addressNotEmptyTest(){
        Customer customer = new Customer("", "", "", 0,null);
        customer.setAddresses(new ArrayList<>());
        assertTrue(customer.getAddresses().isEmpty());
    }
}