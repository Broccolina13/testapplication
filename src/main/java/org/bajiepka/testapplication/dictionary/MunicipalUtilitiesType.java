package org.bajiepka.testapplication.dictionary;

import java.util.Arrays;

public enum MunicipalUtilitiesType {
    ENERGY("Электроэнергия", 1, MunicipalUtilityUnit.KWH),
    GAZ("Газ", 3, MunicipalUtilityUnit.CUBM),
    WATER("Водоснабжение", 2, MunicipalUtilityUnit.CUBM),
    FLAT_RATE("Квартплата", 4, MunicipalUtilityUnit.SQRM),
    TRASH_PICKUP("Вывоз мусора", 4, MunicipalUtilityUnit.CUBM),
    COMPLETE_REPAIR("Капитальный ремонт", 4, MunicipalUtilityUnit.SQRM);

    private String name;
    private Integer priority;
    private MunicipalUtilityUnit unit;

    MunicipalUtilitiesType(String name, Integer priority, MunicipalUtilityUnit unit) {
        this.name = name;
        this.priority = priority;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public Integer getPriority() {
        return priority;
    }

    public static MunicipalUtilitiesType findByPriority(Integer priority) {
        return Arrays.stream(values())
                .filter(utilityPriority -> utilityPriority.getPriority().equals(priority))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Вид коммунальных платежей с номером " + priority + " не уществует"));
    }

    public MunicipalUtilityUnit getUnit() {
        return unit;
    }
}
