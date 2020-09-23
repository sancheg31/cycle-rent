package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle, Long> {
    long countAllByWeightGreaterThan(double weight);
//    Page<Bicycle> findAllByPriceOrderByPriceAsc();
}
