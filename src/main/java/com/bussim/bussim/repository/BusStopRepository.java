package com.bussim.bussim.repository;
import java.util.List;


import com.bussim.bussim.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusStopRepository extends JpaRepository<BusStop, Long> {
    List<BusStop> findByBusRouteId(Long routeId);
    List<BusStop> findAllByBusRouteId(Long busRouteId);
    // get stops of a specific route
}
