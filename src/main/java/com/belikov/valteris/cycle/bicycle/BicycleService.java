package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BicycleService {

    @Autowired
    private BicycleRepository bicycleRepository;

    public List<Bicycle> getAll() {
        return bicycleRepository.findAll();
    }

    public Optional<Bicycle> getById(Long id) {
        return bicycleRepository.findById(id);
    }

    public void save(Bicycle newBicycle) {
        bicycleRepository.save(newBicycle);
    }

    public void delete(Long id) {
        bicycleRepository.deleteById(id);
    }
}
