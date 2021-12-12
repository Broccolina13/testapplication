package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.model.VodaCrimeaLocation;
import org.bajiepka.testapplication.model.TariffItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WaterParser {

    private final VodaCrimeaTariffParser vodaCrimeaTariffParser;

    public WaterParser(VodaCrimeaTariffParser vodaCrimeaTariffParser) {
        this.vodaCrimeaTariffParser = vodaCrimeaTariffParser;
    }

    public List<TariffItem> parseWater(VodaCrimeaLocation vodaCrimeaLocation) {
        return vodaCrimeaTariffParser.parseSiteData(vodaCrimeaLocation);
    }
}
