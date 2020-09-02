package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicycleService {

    @Autowired
    private BicycleRepository bicycleRepository;

    public List<Bicycle> getAll() {
        return bicycleRepository.findAll();
    }

}
