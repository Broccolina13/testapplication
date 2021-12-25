package org.bajiepka.testapplication.model;

import java.time.Instant;

public record RateItem(
        String srcCurrency,
        String destCurrency,
        Float currencyRate,
        Instant date
) {}
