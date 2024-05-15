package org.caglar.flightsearchapi.controller;

import org.caglar.flightsearchapi.models.Airport;
import org.caglar.flightsearchapi.models.dto.AirportDTO;
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
    public AirportDTO save(@RequestBody AirportDTO airportDTO) {
        return airportService.save(airportDTO);
    }

    @GetMapping
    public AirportDTO getByCityCode (@RequestParam String cityCode){
        return airportService.getByCityCode(cityCode);
    }
}
