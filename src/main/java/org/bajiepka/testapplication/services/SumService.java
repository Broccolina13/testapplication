package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.dto.CreateMeterRequest;
import org.bajiepka.testapplication.dto.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SumService {

    private final MeterCountService meterCountService;
    private final PriceService priceService;

    public SumService(MeterCountService meterCountService, PriceService priceService) {
        this.meterCountService = meterCountService;
        this.priceService = priceService;
    }

    public Integer calculateMeterSum() {

        List<CreateMeterRequest> allMeters = meterCountService.getAllCount();
        List<Price> allPrices = priceService.getPrices();
        Price lastPrice = allPrices.get(allPrices.size() - 1);

        int sum = 0;

        for (CreateMeterRequest meter : allMeters) {
            sum = sum + meter.count() * lastPrice.value();
        }

        return sum;
    }
}
