package org.bajiepka.testapplication.services;

import com.fasterxml.jackson.core.type.TypeReference;
import org.bajiepka.testapplication.model.ApiLayerResponse;
import org.bajiepka.testapplication.model.Currency;
import org.bajiepka.testapplication.model.CurrencyItem;
import org.bajiepka.testapplication.model.RateItem;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ApiLayerCurrencyService {

    private final String SERVICE_URL = "https://currate.ru/api/";

    public List<CurrencyItem> getCurrencies() {
        return Stream.of(Currency.values())
                .map(this::toCurrencyItem)
                .sorted(Comparator.comparing(CurrencyItem::id))
                .collect(Collectors.toList());
    }

    public List<RateItem> getCurrencyRate() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> variables = new HashMap<>();
        variables.put("key", "f496f28e86ec97168c39b9ce1920de38");
        variables.put("pairs", "RUBUSD,RUBEUR");

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(SERVICE_URL)
                .queryParam("get", "rates")
                .queryParam("key", "{key}")
                .queryParam("pairs", "{pairs}")
                .encode()
                .toUriString();

        ApiLayerResponse response = restTemplate.getForObject(
                urlTemplate,
                ApiLayerResponse.class,
                variables);
        return Collections.emptyList();
    }

    private CurrencyItem toCurrencyItem(Currency currency) {
        return new CurrencyItem(
                currency.getCode(),
                currency.name(),
                currency.getDescription());
    }
}
