package org.bajiepka.testapplication.repository;

import org.bajiepka.testapplication.dto.CreateMeterRequest;

import java.util.List;

public interface IMeterCountRepository {

    List<CreateMeterRequest> getAllCounts();

    //метод по добавлению новых показаний
    //модификатор доступа
    //[модификатор_доступа] [возвращаемое_значение] [имя_метода] (параметры_метода)
    void addNewCount(CreateMeterRequest newCount);
}
