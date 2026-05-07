package com.cozycreations.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cozycreations.backend.entities.CustomerOrder;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
}
