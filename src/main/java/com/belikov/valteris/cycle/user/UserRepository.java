package com.belikov.valteris.cycle.user;

import com.belikov.valteris.cycle.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
