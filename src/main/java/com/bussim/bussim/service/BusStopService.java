package com.bussim.bussim.service;

import com.bussim.bussim.entity.BusStop;
import com.bussim.bussim.entity.BusRoute;
import com.bussim.bussim.exception.ResourceNotFoundException;
import com.bussim.bussim.repository.BusStopRepository;
import com.bussim.bussim.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusStopService {

    @Autowired
    private BusStopRepository busStopRepository;

    @Autowired
    private BusRouteRepository busRouteRepository;

    // Get all stops
    public List<BusStop> getAllStops() {
        return busStopRepository.findAll();
    }

    // Get stop by ID
    public BusStop getStopById(Long id) {
        return busStopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus stop not found with ID: " + id));
    }

    // Save or update stop
    public BusStop saveStop(BusStop stop) {
        if (stop.getBusRoute() == null || stop.getBusRoute().getId() == null) {
            throw new ResourceNotFoundException("Bus route must be specified for this stop.");
        }

        // Validate that the route exists
        BusRoute route = busRouteRepository.findById(stop.getBusRoute().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Bus route not found with ID: " + stop.getBusRoute().getId()));

        stop.setBusRoute(route);
        return busStopRepository.save(stop);
    }

    // Get stops by route ID
    public List<BusStop> getStopsByRouteId(Long routeId) {
        BusRoute route = busRouteRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus route not found with ID: " + routeId));
        return route.getStops();
    }

    // Delete stop
    public void deleteStop(Long id) {
        BusStop stop = busStopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus stop not found with ID: " + id));
        busStopRepository.delete(stop);
    }
}
