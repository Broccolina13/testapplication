package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.dto.meter.count.CreateMeterCountRequestDTO;
import org.bajiepka.testapplication.repository.MeterCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterCountService {

    @Autowired
    private MeterCountRepository meterCountRepository;

    public List<CreateMeterCountRequestDTO> getAllCount(){
        return meterCountRepository.getAllCounts();
    }

    public String addNewMeterCount(CreateMeterCountRequestDTO dto) {
        meterCountRepository.addNewCount(dto);
        return "Я создала новые показания";
    }


}
