package org.caglar.flightsearchapi.controller;

import org.caglar.flightsearchapi.service.FlightService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
    FlightService flightService;

    FlightController (FlightService flightService) {
        this.flightService = flightService;
    }
}
