package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.dto.CreatePriceRequest;
import org.bajiepka.testapplication.dto.Price;
import org.bajiepka.testapplication.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> getPrices() {
        return priceRepository.getAllPrices();
    }

    public String addPrice(CreatePriceRequest dto) {
        Price price = new Price(dto.price());
        priceRepository.addPrice(price);
        return "Цена добавлена";
    }

    public String deletePrices() {
        //  Мы пришли в этот метод и после того как сделаем очистку мы должны вернуть сообщение:
        //  1. Вызвать очистку
        //  2. Вернуть сообщение
        priceRepository.deleteAllPrices();
        return "Цены очищены.";
    }
}
