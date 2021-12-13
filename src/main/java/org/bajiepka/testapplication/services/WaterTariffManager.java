package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.model.VodaCrimeaLocation;
import org.bajiepka.testapplication.model.WaterItems;
import org.bajiepka.testapplication.services.parser.VodaCrimeaSiteParser;
import org.springframework.stereotype.Service;

@Service
public class WaterTariffManager {

    private final VodaCrimeaSiteParser vodaCrimeaTariffParser;

    public WaterTariffManager(VodaCrimeaSiteParser vodaCrimeaTariffParser) {
        this.vodaCrimeaTariffParser = vodaCrimeaTariffParser;
    }

    public WaterItems getItems(VodaCrimeaLocation vodaCrimeaLocation) {
        return vodaCrimeaTariffParser.parseSiteData(vodaCrimeaLocation);
    }
}
