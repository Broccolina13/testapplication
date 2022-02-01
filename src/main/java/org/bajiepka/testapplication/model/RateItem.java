package org.bajiepka.testapplication.model;

import java.time.Instant;

public record RateItem (
        Currency srcCurrency,
        Currency destCurrency,
        Float currencyRate,
        Instant date
) {}