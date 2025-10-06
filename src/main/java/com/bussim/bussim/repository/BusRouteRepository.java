package com.bussim.bussim.repository;

import com.bussim.bussim.entity.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
    // Custom queries can be added here if needed
}
