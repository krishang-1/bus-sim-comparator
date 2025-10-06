package com.bussim.bussim.controller;

import com.bussim.bussim.entity.BusStop;
import com.bussim.bussim.service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stops")
@CrossOrigin(origins = "*")
public class BusStopController {

    @Autowired
    private BusStopService busStopService;

    @GetMapping
    public List<BusStop> getAllStops() {
        return busStopService.getAllStops();
    }

    @GetMapping("/{id}")
    public Optional<BusStop> getStopById(@PathVariable Long id) {
        return Optional.ofNullable(busStopService.getStopById(id));
    }

    @PostMapping
    public BusStop createStop(@RequestBody BusStop stop) {
        return busStopService.saveStop(stop);
    }

    @GetMapping("/route/{routeId}")
    public List<BusStop> getStopsByRoute(@PathVariable Long routeId) {
        return busStopService.getStopsByRouteId(routeId);
    }
}
