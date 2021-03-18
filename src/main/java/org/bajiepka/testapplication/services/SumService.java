package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.dto.meter.count.CreateMeterCountRequestDTO;
import org.bajiepka.testapplication.dto.price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SumService {

    @Autowired
    private MeterCountService meterCountService;
    @Autowired
    private PriceService priceService;

    public Integer calculateMeterSum() {

        //  1. Получает все показания
        List<CreateMeterCountRequestDTO> allMeters = meterCountService.getAllCount();
        //  2. Полуает все цены
        List<Price> allPrices = priceService.getPrices();
        //  int[] allPrices = new int[] {1, 2, 3 };
        //  int arrLength = allPrices.length
        //  int lastElement = allPrices[arrLength - 1]
        Price lastPrice = allPrices.get(allPrices.size() - 1);

//        IntSummaryStatistics sum = allMeters.stream()
//                .map(CreateMeterCountRequestDTO::getCount)
//                .map(c -> c * lastPrice.getValue())
//                .collect(Collectors.summarizingInt(Integer::intValue));

//        for (CreateMeterCountRequestDTO meter : allMeters) {
//            meter *= lastPrice.getValue();
//        }

        //  а) Обойти все элементы allMeters
        //  б) умножить каждый из них на значение последней цены
        //  в) вернуть сумму знаений из "б"
        int sum = 0;
//        for (int i = 0; i < allMeters.size(); i++) {
        for (CreateMeterCountRequestDTO meter : allMeters) {
//            int currentValue = allMeters.get(i).getCount();
//            int priceOfMeter = currentValue * lastPrice.getValue();
//            sum = sum + priceOfMeter;
            sum = sum + meter.getCount() * lastPrice.getValue();
        }

        return sum;
    }
}
