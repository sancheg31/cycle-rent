package com.belikov.valteris.cycle.detail;

import com.belikov.valteris.cycle.detail.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

}
