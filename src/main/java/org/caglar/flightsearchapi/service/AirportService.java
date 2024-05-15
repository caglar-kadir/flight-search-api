package org.caglar.flightsearchapi.service;

import org.caglar.flightsearchapi.models.Airport;
import org.caglar.flightsearchapi.models.dto.AirportDTO;
import org.caglar.flightsearchapi.repository.AirportRepository;
import org.caglar.flightsearchapi.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    AirportRepository airportRepository;

    @Autowired
    AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public AirportDTO save(AirportDTO airportDTO) {
        Airport airport = MapperUtil.instance().map(airportDTO, Airport.class);
        if (airport != null) {
            airportRepository.save(airport);
            return airportDTO;
        }
        return null;
    }

    public AirportDTO getByCityCode(String cityCode) {
        if (!cityCode.isEmpty()) {
            Airport airport = airportRepository.findByCityCode(cityCode);
            if (airport != null) {
                return MapperUtil.instance().map(airport, AirportDTO.class);
            }
        }
        return null;
    }
}
