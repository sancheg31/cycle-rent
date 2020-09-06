package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;

import java.util.List;
import java.util.Optional;

public interface BicycleService {
    List<Bicycle> getAll();

    Optional<Bicycle> getById(Long id);

    void save(Bicycle newBicycle);

    void delete(Long id);
}
