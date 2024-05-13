package org.caglar.flightsearchapi.controller;

import org.caglar.flightsearchapi.models.Flight;
import org.caglar.flightsearchapi.service.FlightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight-search/v1")
public class FlightController {
    FlightService flightService;

    FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public Flight save(@RequestBody Flight flight) throws Exception {
        return flightService.save(flight);
    }
}
