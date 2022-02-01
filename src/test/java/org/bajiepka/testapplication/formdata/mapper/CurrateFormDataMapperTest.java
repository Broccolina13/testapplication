package org.bajiepka.testapplication.formdata.mapper;

import org.bajiepka.testapplication.formdata.CurrencyFormData;
import org.bajiepka.testapplication.model.Currency;
import org.bajiepka.testapplication.model.RateItem;
import org.bajiepka.testapplication.services.currate.model.CurrateCurrencyRatesResponse;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrateFormDataMapperTest {

    private final CurrateFormDataMapper mapper = new CurrateFormDataMapper();

    @Test
    void mapToFormData() {

        CurrateCurrencyRatesResponse currateCurrencyRatesResponse = new CurrateCurrencyRatesResponse(
                Map.of(
                        "EURRUB", 69.244f,
                        "UAHRUB", 2.62237f,
                        "USDRUB", 64.1824f
                )
        );

        CurrencyFormData formData = mapper.mapToFormData(currateCurrencyRatesResponse);

        RateItem firstElement = formData.rates().get(0);
        assertEquals(Currency.USD, firstElement.srcCurrency());
        assertEquals(64.1824f, firstElement.currencyRate());

        RateItem secondElement = formData.rates().get(1);
        assertEquals(Currency.EUR, secondElement.srcCurrency());
        assertEquals(69.244f, secondElement.currencyRate());

        RateItem thirdElement = formData.rates().get(2);
        assertEquals(Currency.UAH, thirdElement.srcCurrency());
        assertEquals(2.62237f, thirdElement.currencyRate());
    }
}