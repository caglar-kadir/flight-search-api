package org.caglar.flightsearchapi.controller;

import org.caglar.flightsearchapi.models.dto.CreateAirport;
import org.caglar.flightsearchapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport/v1")
public class AirportController {
    AirportService airportService;

    @Autowired
    AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public CreateAirport save(@RequestBody CreateAirport airportDTO) {
        return airportService.save(airportDTO);
    }

    @GetMapping("/city")
    public CreateAirport getByCityCode (@RequestParam String cityCode){
        return airportService.getByCityCode(cityCode);
    }
}
