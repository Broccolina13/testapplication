package org.bajiepka.testapplication.repository;

import org.bajiepka.testapplication.dto.price.Price;
import org.bajiepka.testapplication.entity.Abonent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AbonentRepository {
    private List<Abonent> abonents  = new ArrayList<>();

    //  TODO Реализовать метод, который получит из abonents абонента по коду (id)
    public List<Abonent> getAbonentById() {
        return abonents;
    }

    public String save(Abonent abonent) {
        abonent.setId(String.valueOf(abonents.size()));
        abonents.add(abonent);
        return abonent.getId();
    }


}
