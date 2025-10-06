package com.bussim.bussim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

    @GetMapping("/bus/status")
    public String getStatus() {
        return "Bus Simulation Running";
    }
}
