package org.bajiepka.testapplication.model;

public enum Currency {

    EUR(978L, "Euro", "Евро"),
    RUB(643L, "Russian ruble", "Российский рубль"),
    UAH(980L, "Ukrainian hryvna", "Украинская гривна"),
    USD(840L, "United States dollar", "Американский доллар");

    Currency(
            Long currencyCode,
            String currencyName,
            String currencyDescription
    ) {
        this.label = currencyName;
        this.code = currencyCode;
        this.description = currencyDescription;
    }

    Long code;
    String label;
    String description;

    public String getLabel() {
        return label;
    }

    public Long getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
