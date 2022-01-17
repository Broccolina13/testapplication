package org.bajiepka.testapplication.dto;

import org.bajiepka.testapplication.dictionary.MunicipalUtilitiesType;

public record CreateMeterRequest(MunicipalUtilitiesType type, Integer count) {}
