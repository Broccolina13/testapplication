package org.bajiepka.testapplication.services.currate;

import org.bajiepka.testapplication.model.Currency;
import org.bajiepka.testapplication.model.CurrencyItem;
import org.bajiepka.testapplication.model.RateItem;
import org.bajiepka.testapplication.services.Url;
import org.bajiepka.testapplication.services.currate.model.CurrateCurrencyRatesResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
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

        if (response == null) throw new IllegalStateException("Мы ничего не получили от апи курсов валют!");

        List<RateItem> currencyRates = new ArrayList<>();
        for (Map.Entry<String, Float> entry : response.data().entrySet()) {
            currencyRates.add(new RateItem(
                    entry.getKey().substring(0, 3),
                    entry.getKey().substring(3, 6),
                    entry.getValue(),
                    Instant.now()
            ));
        }

        return currencyRates;
    }

    private String generateCurrencyPairs() {
        Currency[] currencies = Currency.values();
        List<String> generatedPairList = new ArrayList<>();

        for (int i = 0; i < currencies.length; i++) {
            //  Если это рубль - не заполняем пару
            //  Если это другая валюта - заполняем пару, а RUB приклеиваем спереди
            Currency currentCurrency = currencies[i];
            if (currentCurrency.equals(Currency.RUB)) {
                continue;
            } else {
                generatedPairList.add(Currency.getBaseCurrency().name() + currentCurrency.name());
            }
        }

        return String.join(",", generatedPairList);
    }

    private Map<String, ?> getCurrencyRateVariables() {
        return Map.of(
                "key", apiKey,
                "pairs", generateCurrencyPairs());
    }

    private CurrencyItem toCurrencyItem(Currency currency) {
        return new CurrencyItem(
                currency.getCode(),
                currency.name(),
                currency.getDescription());
    }
}
