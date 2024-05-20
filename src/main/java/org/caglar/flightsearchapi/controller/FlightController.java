package org.caglar.flightsearchapi.controller;

import org.caglar.flightsearchapi.exceptions.InvalidDateException;
import org.caglar.flightsearchapi.exceptions.InvalidPriceException;
import org.caglar.flightsearchapi.exceptions.airportExceptions.AirportNotFoundException;
import org.caglar.flightsearchapi.models.dto.FlightDTO;
import org.caglar.flightsearchapi.service.FlightService;
import org.caglar.flightsearchapi.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/flight-search/v1")
public class FlightController {
    FlightService flightService;


    @Autowired
    FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public FlightDTO save(@RequestBody FlightDTO flightDTO,
                             @RequestParam String departureAirport,
                             @RequestParam String arrivalAirport) throws AirportNotFoundException, InvalidPriceException, InvalidDateException {
        return MapperUtil.map(flightService.save(flightDTO, departureAirport, arrivalAirport), FlightDTO.class);
    }

    @GetMapping("/{id}")
    public FlightDTO getById(@PathVariable UUID id) {
        return MapperUtil.map( flightService.getById(id),FlightDTO.class);
    }

    @GetMapping("/search")
    public List<FlightDTO> getByDateAndAirport (
            @RequestParam String startTime,
            @RequestParam String endTime,
            @RequestParam String departure,
            @RequestParam String arrival
    ) throws AirportNotFoundException {
        return Arrays.asList(MapperUtil.map(flightService.getByDateAndAirport(startTime, endTime, departure, arrival), FlightDTO[].class));
    }
}
