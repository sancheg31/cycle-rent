package com.belikov.valteris.cycle.detail;

import com.belikov.valteris.cycle.detail.model.Detail;

import java.util.List;
import java.util.Optional;

public interface DetailService {
    void save(Detail newDetail);

    List<Detail> getAll();

    Optional<Detail> getById(Long id);

    void delete(Long id);
}
