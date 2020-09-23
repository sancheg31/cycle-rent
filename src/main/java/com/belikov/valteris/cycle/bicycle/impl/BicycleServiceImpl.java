package com.belikov.valteris.cycle.bicycle.impl;

import com.belikov.valteris.cycle.bicycle.BicycleRepository;
import com.belikov.valteris.cycle.bicycle.BicycleService;
import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import com.belikov.valteris.cycle.bicycle.model.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.belikov.valteris.cycle.util.ServiceUtil.getNumberOfPages;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BicycleServiceImpl implements BicycleService {

    private static final int ITEMS_PER_PAGE = 3;
    private final BicycleRepository bicycleRepository;

    @Override
    public List<Bicycle> getAll() {
        return bicycleRepository.findAll();
    }

    @Override
    public Page<Bicycle> findPage(int pageNumber) {
        Pageable bicyclePage = PageRequest.of(pageNumber - 1, ITEMS_PER_PAGE);
        return bicycleRepository.findAll(bicyclePage);
    }

    @Override
    public int pageCount() {
        return getNumberOfPages(bicycleRepository.countAllByWeightGreaterThan(0), ITEMS_PER_PAGE);
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

    @Override
    public Page<Bicycle> findSortedPage(SortType typeOfSort, int numberOfPage) {
        Pageable bicyclePage = PageRequest.of(numberOfPage - 1, ITEMS_PER_PAGE);
        return bicycleRepository.findAll(bicyclePage);
    }
}
