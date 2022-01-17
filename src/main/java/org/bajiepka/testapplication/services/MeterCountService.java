package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.dto.CreateMeterRequest;
import org.bajiepka.testapplication.repository.MeterCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterCountService {

    @Autowired
    private MeterCountRepository meterCountRepository;

    public List<CreateMeterRequest> getAllCount(){
        return meterCountRepository.getAllCounts();
    }

    public String addNewMeterCount(CreateMeterRequest dto) {
        meterCountRepository.addNewCount(dto);
        return "Я создала новые показания";
    }


}
