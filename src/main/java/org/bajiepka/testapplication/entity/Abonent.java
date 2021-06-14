package org.bajiepka.testapplication.entity;

import org.bajiepka.testapplication.dto.meter.count.CreateMeterCountRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class Abonent {

    public Abonent(String id,
                   String name,
                   String lastName,
                   int age,
                   Long balance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.balance = balance;
    }

    public static final int MINIMUM_ABONENT_AGE = 16;
    public static final int MAXIMUM_ABONENT_AGE = 120;

    private String id;
    private String name;
    private String lastName;
    private int age;
    private Long balance;
    private List<String> addresses;

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    private List<CreateMeterCountRequestDTO> counts = new ArrayList<>();

    public String getFIO() {
        return lastName + " " + name;
    }

    public boolean isGoodByAge() {
        if (age > MAXIMUM_ABONENT_AGE) {
            System.out.println("Пользователь слишком стар.");
        }
        if (age < MINIMUM_ABONENT_AGE) {
            System.out.println("Слишком мал, денег нет.");
        }
        return age < MAXIMUM_ABONENT_AGE && age > MINIMUM_ABONENT_AGE;
    }

    public boolean isAbonentHasDebt() {
        return balance < 0;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Long getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }
}