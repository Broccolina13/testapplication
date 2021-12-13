package org.bajiepka.testapplication.model;

import java.util.List;

public record WaterItems(List<TariffItem> in, List<TariffItem> out) {
}
