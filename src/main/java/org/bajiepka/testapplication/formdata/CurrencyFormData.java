package org.bajiepka.testapplication.formdata;

import org.bajiepka.testapplication.model.Currency;
import org.bajiepka.testapplication.model.RateItem;

import java.time.LocalDate;
import java.util.List;

public record CurrencyFormData(
        Currency mainCurrency,
        List<RateItem> rates
) {
    public String getFormHeader() {
        return "Курс валют по отношению к " + mainCurrency + " по состоянию на (" + LocalDate.now() + ")";
    }
}
