package org.bajiepka.testapplication.entity;

public class Address {
    private Integer postCode;
    private String city;
    private String street;
    private String house;

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

}