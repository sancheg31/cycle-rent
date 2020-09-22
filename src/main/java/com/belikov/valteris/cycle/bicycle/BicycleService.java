package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import com.belikov.valteris.cycle.bicycle.model.SortType;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BicycleService {
    List<Bicycle> getAll();

    Page<Bicycle> findPage(int pageNumber);

    int pageCount();

    Optional<Bicycle> getById(Long id);

    void save(Bicycle newBicycle);

    void delete(Long id);

    Page<Bicycle> findSortedPage(SortType typeOfSort, int numberOfPage);
}
