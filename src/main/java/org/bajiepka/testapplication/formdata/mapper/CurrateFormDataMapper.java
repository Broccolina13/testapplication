package org.bajiepka.testapplication.formdata.mapper;

import org.bajiepka.testapplication.formdata.CurrencyFormData;
import org.bajiepka.testapplication.model.Currency;
import org.bajiepka.testapplication.model.RateItem;
import org.bajiepka.testapplication.services.currate.model.CurrateCurrencyRatesResponse;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Компонент предназначен для обработки ответа от серсиса currate.ru
 * и формирования данных для frontend формы.
 */
@Component
public class CurrateFormDataMapper {

    private final static int SOURCE_CURRENCY_END_PREFIX = 3;
    private final static int DEST_CURRENCY_END_PREFIX = 6;

    public CurrencyFormData mapToFormData(CurrateCurrencyRatesResponse response) {
        List<RateItem> currencyRates = new ArrayList<>();
        for (Map.Entry<String, Float> entry : response.data().entrySet()) {
            currencyRates.add(
                    new RateItem(
                            getSourceCurrency(entry.getKey()),
                            getDestCurrency(entry.getKey()),
                            entry.getValue(),
                            Instant.now()
                    ));
        }
        return new CurrencyFormData(
                Currency.getBaseCurrency(),
                currencyRates);
    }

    private Currency getSourceCurrency(String value) {
        String symbols = value.substring(0, SOURCE_CURRENCY_END_PREFIX);
        return Currency.valueOf(symbols);
    }

    private Currency getDestCurrency(String value) {
        String symbols = value.substring(SOURCE_CURRENCY_END_PREFIX, DEST_CURRENCY_END_PREFIX);
        return Currency.valueOf(symbols);
    }
}
