package org.bajiepka.testapplication.services.currate;

import org.bajiepka.testapplication.services.currate.model.CurrateCurrencyRatesResponse;
import org.bajiepka.testapplication.model.Currency;
import org.bajiepka.testapplication.model.CurrencyItem;
import org.bajiepka.testapplication.model.RateItem;
import org.bajiepka.testapplication.services.Url;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class CurrateCurrencyService {

    @Value("${http.currate.api-key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public CurrateCurrencyService(
            @Qualifier("currateRestTemplate") RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }

    public List<CurrencyItem> getCurrencies() {
        return Stream.of(Currency.values())
                .map(this::toCurrencyItem)
                .sorted(Comparator.comparing(CurrencyItem::id))
                .collect(Collectors.toList());
    }

    public List<RateItem> getCurrencyRate() {
        CurrateCurrencyRatesResponse response = restTemplate.getForObject(
                Url.CURRATE_RU_RATES_URL,
                CurrateCurrencyRatesResponse.class,
                getCurrencyRateVariables()
        );

        //  TODO смапить ответ в список RateItem
        return Collections.emptyList();
    }

    private Map<String, ?> getCurrencyRateVariables() {
        return Map.of(
                "key", apiKey,
                //  TODO
                //      - генерировать пары согласно существующим валютам из перечисления Currency, кроме RUB
                //      - рубль вынести в основную валюту
                "pairs", "RUBUSD,RUBEUR");
    }

    private CurrencyItem toCurrencyItem(Currency currency) {
        return new CurrencyItem(
                currency.getCode(),
                currency.name(),
                currency.getDescription());
    }
}
