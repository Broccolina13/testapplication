package org.bajiepka.testapplication.repository;

import org.bajiepka.testapplication.dto.price.CreatePriceRequestDTO;
import org.bajiepka.testapplication.dto.price.Price;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceRepository {
    private List<Price> prices  = new ArrayList<>();

    public List<Price> getAllPrices() {
        return prices;
    }

    public void addPrice(Price dto) {
        prices.add(dto);
    }

    public void addAllPrices(List<Price> prices) {
        this.prices.addAll(prices);
    }

    public void deleteAllPrices() {
        prices.clear();
    }
}
