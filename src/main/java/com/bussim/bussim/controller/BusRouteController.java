package com.bussim.bussim.controller;

import com.bussim.bussim.entity.BusRoute;
import com.bussim.bussim.entity.BusStop;
import com.bussim.bussim.service.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "*")
public class BusRouteController {

    @Autowired
    private BusRouteService busRouteService;

    @GetMapping
    public List<BusRoute> getAllRoutes() {
        return busRouteService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public Optional<BusRoute> getRouteById(@PathVariable Long id) {
        return Optional.ofNullable(busRouteService.getRouteById(id));
    }

    @PostMapping
    public BusRoute createRoute(@RequestBody BusRoute route) {
        return busRouteService.saveRoute(route);
    }

    @GetMapping("/{id}/stops")
    public List<BusStop> getStopsForRoute(@PathVariable Long id) {
        return busRouteService.getStopsForRoute(id);
    }
}
