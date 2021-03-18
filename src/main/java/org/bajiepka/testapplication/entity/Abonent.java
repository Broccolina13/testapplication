package org.bajiepka.testapplication.entity;

import org.bajiepka.testapplication.dto.meter.count.CreateMeterCountRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class Abonent {

    public Abonent(String id,
                   String name,
                   String lastName,
                   int age,
                   Long balance,
                   Integer postCode,
                   String city,
                   String street,
                   String house) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.balance = balance;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public static final int MINIMUM_ABONENT_AGE = 16;
    public static final int MAXIMUM_ABONENT_AGE = 120;

    private String id;
    private String name;
    private String lastName;
    private int age;
    private Long balance;
    private Integer postCode;
    private String city;
    private String street;
    private String house;

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

    public boolean isAbonentIsKerchAbonent() {
        int kerchIndex1 = 298300;
        int kerchIndex2 = 298302;
        return postCode == kerchIndex1 || postCode == kerchIndex2;
    }

    public boolean isOsadchi() {
        return postCode == 999999;
    }

    public String getFullAdress() {
//        return String.format("%s, город %s, улица %s, дом %d",
//                postCode,   // 1
//                city,       // 2
//                street,     // 3
//                house);     // 4

        return postCode + ", г. " + city + ", ул. " + street + ", д. " + house + ".";
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