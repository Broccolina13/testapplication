package org.bajiepka.testapplication.config.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class CurrateConfiguration {

    @Bean("currateRestTemplate")
    public RestTemplate restTemplate(
            RestTemplateBuilder restTemplateBuilder
    ) {
        RestTemplate template = restTemplateBuilder.build();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(
                MediaType.TEXT_HTML,
                MediaType.APPLICATION_JSON
        ));
        template.getMessageConverters().add(converter);
        return template;
    }
}
