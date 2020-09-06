package com.belikov.valteris.cycle.detail.impl;

import com.belikov.valteris.cycle.detail.DetailRepository;
import com.belikov.valteris.cycle.detail.DetailService;
import com.belikov.valteris.cycle.detail.model.Detail;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DetailServiceImpl implements DetailService {

    private DetailRepository detailRepository;

    @Override
    public void save(Detail newDetail) {
        detailRepository.save(newDetail);
    }

    @Override
    public List<Detail> getAll() {
        return detailRepository.findAll();
    }

    @Override
    public Optional<Detail> getById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        detailRepository.deleteById(id);
    }
}
