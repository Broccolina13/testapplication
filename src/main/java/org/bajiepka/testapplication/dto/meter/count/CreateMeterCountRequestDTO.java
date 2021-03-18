package org.bajiepka.testapplication.dto.meter.count;

import org.bajiepka.testapplication.dictionary.MunicipalUtilitiesType;

public class CreateMeterCountRequestDTO {

    private MunicipalUtilitiesType type;
    private Integer count;

    public CreateMeterCountRequestDTO(MunicipalUtilitiesType type, Integer count) {
        this.type = type;
        this.count = count;
    }

    public MunicipalUtilitiesType getType() {
        return type;
    }

    public Integer getCount() {
        return count;
    }
}
