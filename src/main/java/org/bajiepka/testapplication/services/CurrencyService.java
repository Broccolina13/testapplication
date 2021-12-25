package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

//    public String getCurrencyRate(){
//        RestTemplate restTemplate = new RestTemplate();
//  String fooResourceUrl
//                = "http://apilayer.net/api/live?access_key=5236c487397010f324bfd49c880fcd85&currencies=EUR,GBP,CAD,PLN&source=USD&format=1";
//        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
//
//        return response.getBody();
//    }

    public List<RateItem> getCurrencyRate() {
        RestTemplate restTemplate = new RestTemplate();
        Foo response = restTemplate.getForObject( "http://apilayer.net/api/live?access_key=5236c487397010f324bfd49c880fcd85&currencies=EUR,GBP,CAD,PLN&source=USD&format=1",
                Foo.class, "java");
        return Stream.of(response).
                map(this::toRateItem)
                .sorted(Comparator.comparing(RateItem::convertCurrency))
                .collect(Collectors.toList());
    }


    private CurrencyItem toCurrencyItem(Currency currency) {
        return new CurrencyItem(
                currency.getCode(),
                currency.name(),
                currency.getDescription());
    }

    private RateItem toRateItem(Foo rates) {
        return new RateItem(
                rates.getSourseCurrency(),
                rates.getConvertCurrency(),
                rates.getCourse(),
                rates.getDate());
    }

}
