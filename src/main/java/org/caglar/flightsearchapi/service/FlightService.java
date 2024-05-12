package org.caglar.flightsearchapi.service;

import org.caglar.flightsearchapi.repository.FlightRepository;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    FlightRepository flightRepository;

    FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }


}
