package com.bussim.bussim.service;

import com.bussim.bussim.entity.BusRoute;
import com.bussim.bussim.entity.BusStop;
import com.bussim.bussim.exception.ResourceNotFoundException;
import com.bussim.bussim.repository.BusRouteRepository;
import com.bussim.bussim.repository.BusStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteService {

    @Autowired
    private BusRouteRepository busRouteRepository;

    @Autowired
    private BusStopRepository busStopRepository;

    // Get all routes
    public List<BusRoute> getAllRoutes() {
        return busRouteRepository.findAll();
    }

    // Get route by ID (throws exception if not found)
    public BusRoute getRouteById(Long id) {
        return busRouteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus route not found with ID: " + id));
    }

    // Save or update route
    public BusRoute saveRoute(BusRoute route) {
        return busRouteRepository.save(route);
    }

    // Get all stops for a given route
    public List<BusStop> getStopsForRoute(Long routeId) {
        BusRoute route = busRouteRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus route not found with ID: " + routeId));
        return route.getStops();
    }

    // Delete route
    public void deleteRoute(Long id) {
        BusRoute route = busRouteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus route not found with ID: " + id));
        busRouteRepository.delete(route);
    }
}
