package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.model.Currency;
import org.bajiepka.testapplication.model.CurrencyItem;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CurrencyService {

    public List<CurrencyItem> getCurrencies() {
        return Stream.of(Currency.values())
                .map(this::toCurrencyItem)
                .sorted(Comparator.comparing(CurrencyItem::id))
                .collect(Collectors.toList());
    }

    private CurrencyItem toCurrencyItem(Currency currency) {
        return new CurrencyItem(
                currency.getCode(),
                currency.getLabel(),
                currency.getDescription());
    }
}
