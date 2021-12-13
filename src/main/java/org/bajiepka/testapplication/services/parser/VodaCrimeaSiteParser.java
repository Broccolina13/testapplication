package org.bajiepka.testapplication.services.parser;

import org.bajiepka.testapplication.model.TariffItem;
import org.bajiepka.testapplication.model.VodaCrimeaDurationHelper;
import org.bajiepka.testapplication.model.VodaCrimeaLocation;
import org.bajiepka.testapplication.model.WaterItems;
import org.bajiepka.testapplication.services.parser.AbstractSiteParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class VodaCrimeaSiteParser extends AbstractSiteParser {

    private final static String VODA_CRIMEA_SITE_URL = "https://voda.crimea.ru/tarify";

    public VodaCrimeaSiteParser() {
        super(VODA_CRIMEA_SITE_URL);
    }

    private final static String KERCH_LOCATION_COLUMN = "г. Керчь";
    private final static String TARIFF_TAB_SELECT = "table[class=tarif-tab]";
    private final static int PEOPLE_TARIFF_INDEX = 1;
    private final static int IN_DURATION_INDEX = 6;
    private final static int OUT_DURATION_INDEX = 5;

    public WaterItems parseSiteData(VodaCrimeaLocation vodaCrimeaLocation) {

        Document document = getDocument();
        String elementQuery = buildDivByIdQuery(vodaCrimeaLocation.getSiteLocationId());
        Element cityElement = getNestedElement(elementQuery, document);
        Elements waterTariffs = cityElement.select(TARIFF_TAB_SELECT);

        Element waterIn = Objects.requireNonNull(waterTariffs.first(), "Отсутствуют тарифы на водоснабжение.");
        Element waterOut = Objects.requireNonNull(waterTariffs.last(), "Отсутствуют тарифы на водоотведение.");

        return new WaterItems(
                extractTariffRows(waterIn.getElementsByTag(TABLE_ROW), IN_DURATION_INDEX),
                extractTariffRows(waterOut.getElementsByTag(TABLE_ROW), OUT_DURATION_INDEX));
    }

    private List<TariffItem> extractTariffRows(List<Element> inTariffRows, int durationIndex) {
        return inTariffRows.stream()
                .filter(kerchPredicate())
                .map(row -> {
                    VodaCrimeaDurationHelper helper = new VodaCrimeaDurationHelper(getFirstChildTextValue(row.child(durationIndex)));
                    String cost = getFirstChildTextValue(row.child(PEOPLE_TARIFF_INDEX));

                    return new TariffItem(
                            helper.getStartDate(),
                            helper.getEndDate(),
                            getTariffCost(cost),
                            isCurrentTariffPredicate().test(helper));
                })
                .sorted(Comparator.comparing(TariffItem::end).reversed())
                .collect(Collectors.toList());
    }

    private Predicate<Element> kerchPredicate() {
        return node -> node.toString().contains(KERCH_LOCATION_COLUMN);
    }

    private Predicate<VodaCrimeaDurationHelper> isCurrentTariffPredicate() {
        LocalDate currentDate = LocalDate.now();
        return helper -> currentDate.isAfter(helper.getStartDate())
                && currentDate.isBefore(helper.getEndDate());
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
}
