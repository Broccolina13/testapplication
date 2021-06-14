package org.bajiepka.testapplication.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbonentTest {
    @Test
    public void adressTest(){
        Abonent abonent = new Abonent("", "", "", 0,null);
        List<String> expectedAddresses = abonent.getAddresses();
        assertNull(expectedAddresses);
    }
    @Test
    public void addressNotEmptyTest(){
        Abonent abonent = new Abonent("", "", "", 0,null);
        abonent.setAddresses(new ArrayList<>());
        assertTrue(abonent.getAddresses().isEmpty());
    }
}