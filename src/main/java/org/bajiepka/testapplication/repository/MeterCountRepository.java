package org.bajiepka.testapplication.repository;

import org.bajiepka.testapplication.dto.CreateMeterRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeterCountRepository implements IMeterCountRepository {

    private List<CreateMeterRequest> counts = new ArrayList<>();

    @Override
    public List<CreateMeterRequest> getAllCounts() {
        return counts;
    }

    @Override
    public void addNewCount(CreateMeterRequest newCount) {
        counts.add(newCount);
    }

}
