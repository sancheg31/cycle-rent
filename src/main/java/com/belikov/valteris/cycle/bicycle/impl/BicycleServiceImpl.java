package com.belikov.valteris.cycle.bicycle.impl;

import com.belikov.valteris.cycle.bicycle.BicycleRepository;
import com.belikov.valteris.cycle.bicycle.BicycleService;
import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BicycleServiceImpl implements BicycleService {

    private BicycleRepository bicycleRepository;

    @Override
    public List<Bicycle> getAll() {
        return bicycleRepository.findAll();
    }

    @Override
    public Optional<Bicycle> getById(Long id) {
        return bicycleRepository.findById(id);
    }

    @Override
    public void save(Bicycle newBicycle) {
        bicycleRepository.save(newBicycle);
    }

    @Override
    public void delete(Long id) {
        bicycleRepository.deleteById(id);
    }
}
