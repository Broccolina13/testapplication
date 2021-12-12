package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.model.TariffItem;
import org.bajiepka.testapplication.model.VodaCrimeaLocation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class VodaCrimeaTariffParser {

    private final static String SITE_URL = "https://voda.crimea.ru/tarify";
    private final static String TARIFF_TAB_SELECT = "table[class=tarif-tab]";
    private final static int PEOPLE_TARIFF_INDEX = 1;
    private final static int DURATION_INDEX = 6;


    public List<TariffItem> parseSiteData(VodaCrimeaLocation vodaCrimeaLocation) {
        try {
            Document document = Jsoup.connect(SITE_URL).get();
            String elementQuery = String.format("div[id=%s]", vodaCrimeaLocation.getSiteLocationId());
            Element cityElement = getNestedElement(elementQuery, document);
            Elements waterTariffs = cityElement.select(TARIFF_TAB_SELECT);
            Element waterIn = waterTariffs.first();
            if (waterIn == null) {
                throw new IllegalStateException("Тарифы на водоснабжение не могут отсутствовать на сайте.");
            }

            List<Element> tariffRows = waterIn.getElementsByTag("tr");

            //  TODO доделать водоотведение
            //  Element waterOut = waterTariffs.last();

            return tariffRows.stream()
                    .filter(node -> node.toString().contains("г. Керчь"))
                    .map(row -> {
                        String[] tariffDuration = getFirstChildTextValue(row.child(DURATION_INDEX))
                                .replace(" ", "")
                                .split("-");
                        String cost = getFirstChildTextValue(row.child(PEOPLE_TARIFF_INDEX));

                        return new TariffItem(
                                getTariffPeriod(tariffDuration[0]),
                                getTariffPeriod(tariffDuration[1]),
                                getTariffCost(cost));
                    })
                    .sorted(Comparator.comparing(TariffItem::end).reversed())
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalStateException("Could not connect to water site");
        }
    }

    private Element getNestedElement(String elementCssQuery, Document document) {
        Element foundedElements = document.select(elementCssQuery).first();
        if (foundedElements == null) {
            throw new IllegalStateException("");
        }
        return foundedElements;
    }

    private String getFirstChildTextValue(Element element) {
        Node node = element.childNodes().iterator().next();
        Attribute firstAttribute = node.attributes().iterator().next();
        return firstAttribute.getValue();
    }

    private Double getTariffCost(String cost) {
        NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
        Number number;
        try {
            number = format.parse(cost);
            return number.doubleValue();
        } catch (ParseException e) {
            return 0.00;
        }
    }

    private LocalDate getTariffPeriod(String date) {
        String[] dates = date.split("\\.");
        int day = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int year = Integer.parseInt(dates[2]);
        if (year < 2000) year += 2000;
        return LocalDate.of(year, month, day);
    }
}
