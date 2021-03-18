package org.bajiepka.testapplication.repository;

import org.bajiepka.testapplication.dto.meter.count.CreateMeterCountRequestDTO;

import java.util.List;

public interface IMeterCountRepository {

    List<CreateMeterCountRequestDTO> getAllCounts();

    //метод по добавлению новых показаний
    //модификатор доступа
    //[модификатор_доступа] [возвращаемое_значение] [имя_метода] (параметры_метода)
    void addNewCount(CreateMeterCountRequestDTO newCount);
}
