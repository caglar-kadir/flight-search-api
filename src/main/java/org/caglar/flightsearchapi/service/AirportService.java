package org.caglar.flightsearchapi.service;

import org.caglar.flightsearchapi.models.Airport;
import org.caglar.flightsearchapi.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    AirportRepository airportRepository;

    @Autowired
    AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport getByCityCode(String cityCode) {
        if (!cityCode.isEmpty()) {
            return airportRepository.findByCityCode(cityCode);
        }
        return null;
    }
}
