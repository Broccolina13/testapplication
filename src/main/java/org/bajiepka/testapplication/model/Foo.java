package org.bajiepka.testapplication.model;

import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

public class Foo implements Serializable {

    String sourseCurrency;
    String convertCurrency;
    Long course;
    Long date;

    public String getSourseCurrency() {
        return sourseCurrency;
    }

    public String getConvertCurrency() {
        return convertCurrency;
    }

    public Long getCourse() {
        return course;
    }

    public Long getDate() {
        return date;
    }

}