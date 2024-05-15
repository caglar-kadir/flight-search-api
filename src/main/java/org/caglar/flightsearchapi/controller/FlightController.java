package org.caglar.flightsearchapi.controller;

import org.caglar.flightsearchapi.exceptions.flightExceptions.FlightNotFoundException;
import org.caglar.flightsearchapi.models.Flight;
import org.caglar.flightsearchapi.models.dto.FlightDTO;
import org.caglar.flightsearchapi.service.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight-search/v1")
public class FlightController {
    FlightService flightService;

    FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public FlightDTO save(@RequestBody FlightDTO flightDTO,
                          @RequestParam String departureAirport,
                          @RequestParam String arrivalAirport) throws Exception {
        return flightService.save(flightDTO, departureAirport, arrivalAirport);
    }

    @GetMapping("/{id}")
    public FlightDTO getById(@PathVariable long id) throws FlightNotFoundException {
        return flightService.getById(id);
    }
}
