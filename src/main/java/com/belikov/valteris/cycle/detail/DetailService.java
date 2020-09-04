package com.belikov.valteris.cycle.detail;

import com.belikov.valteris.cycle.detail.model.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public void add(Detail newDetail) {
        detailRepository.save(newDetail);
    }

    public List<Detail> getAll() {
        return detailRepository.findAll();
    }

    public Optional<Detail> getById(Long id) {
        return detailRepository.findById(id);
    }

    public void delete(Long id) {
        detailRepository.deleteById(id);
    }

}
