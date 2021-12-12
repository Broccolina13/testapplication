package org.bajiepka.testapplication.model;

import java.time.LocalDate;

public record TariffItem(LocalDate start, LocalDate end, Double cost) {
}
