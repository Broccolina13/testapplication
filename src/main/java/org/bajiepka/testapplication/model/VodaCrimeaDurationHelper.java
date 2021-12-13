package org.bajiepka.testapplication.model;

import java.time.LocalDate;

public class VodaCrimeaDurationHelper {

    private final LocalDate startDate;
    private final LocalDate endDate;

    public VodaCrimeaDurationHelper(String literalPeriod) {
        String[] tariffDuration = literalPeriod
                .replace(" ", "")
                .split("-");

        startDate = getTariffPeriod(tariffDuration[0]);
        endDate = getTariffPeriod(tariffDuration[1]);
    }

    private LocalDate getTariffPeriod(String date) {
        String[] dates = date.split("\\.");
        int day = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int year = Integer.parseInt(dates[2]);
        if (year < 2000) year += 2000;
        return LocalDate.of(year, month, day);
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
