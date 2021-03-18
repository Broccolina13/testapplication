package org.bajiepka.testapplication.services;

import org.bajiepka.testapplication.dto.abonent.CreateAbonentDTO;
import org.bajiepka.testapplication.dto.price.Price;
import org.bajiepka.testapplication.entity.Abonent;
import org.bajiepka.testapplication.repository.AbonentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonentService {

    @Autowired
    private AbonentRepository abonentRepository;

    //  TODO реализовать метод, который будет получать из репозитория абонента по коду
    public List<Abonent> getAbonentListById() {
        return abonentRepository.getAbonentById();
    }

    public String createAbonent(CreateAbonentDTO dto){

        Abonent abonent = new Abonent("",
                dto.getName(),
                dto.getLastName(),
                Integer.parseInt(dto.getClientAge()),
                0L,
                Integer.parseInt(dto.getPostalCode()),
                "",
                "",
                "");
        return abonentRepository.save(abonent);
    }

}
