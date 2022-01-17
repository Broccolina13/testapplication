package org.bajiepka.testapplication.services.currate.model;

import java.util.Map;

public record CurrateCurrencyRatesResponse(
        Map<String, Float> data
) {
}