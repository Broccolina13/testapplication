package org.bajiepka.testapplication.services;

import org.springframework.web.util.UriComponentsBuilder;

public interface Url {

    String CURRATE_RU_URL = "https://currate.ru/api/";

    String CURRATE_RU_RATES_URL = UriComponentsBuilder.fromHttpUrl(Url.CURRATE_RU_URL)
            .queryParam("get", "rates")
            .queryParam("key", "{key}")
            .queryParam("pairs", "{pairs}")
            .encode()
            .toUriString();
}
