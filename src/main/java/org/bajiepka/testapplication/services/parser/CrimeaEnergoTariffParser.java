package org.bajiepka.testapplication.services.parser;

import org.bajiepka.testapplication.model.EnergyItems;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CrimeaEnergoTariffParser extends AbstractSiteParser {
    private final static String SITE_URL = "https://crimea-energy.ru/consumers/price/tariful-2";

    public CrimeaEnergoTariffParser() {
        super(SITE_URL);
    }

    public EnergyItems parseSiteData() {
        Document document = getDocument();
        return new EnergyItems(Collections.emptyList());
    }
}
