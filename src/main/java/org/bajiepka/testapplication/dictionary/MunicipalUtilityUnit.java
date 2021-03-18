package org.bajiepka.testapplication.dictionary;

public enum MunicipalUtilityUnit {

    KWH("кВт*ч"),
    CUBM("куб. м"),
    SQRM("кв. м");

    private String name;

    MunicipalUtilityUnit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
