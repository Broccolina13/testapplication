package org.bajiepka.testapplication.repository;

import org.bajiepka.testapplication.dto.meter.count.CreateMeterCountRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeterCountRepository implements IMeterCountRepository {

    private List<CreateMeterCountRequestDTO> counts = new ArrayList<>();

    @Override
    public List<CreateMeterCountRequestDTO> getAllCounts() {
        return counts;
    }

    @Override
    public void addNewCount(CreateMeterCountRequestDTO newCount) {
        counts.add(newCount);
    }

}
