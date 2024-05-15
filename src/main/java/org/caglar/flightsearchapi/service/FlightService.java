package org.caglar.flightsearchapi.service;

import org.caglar.flightsearchapi.exceptions.InvalidDateException;
import org.caglar.flightsearchapi.exceptions.InvalidPriceException;
import org.caglar.flightsearchapi.exceptions.airportExceptions.AirportNotFoundException;
import org.caglar.flightsearchapi.models.Flight;
import org.caglar.flightsearchapi.models.dto.FlightDTO;
import org.caglar.flightsearchapi.repository.AirportRepository;
import org.caglar.flightsearchapi.repository.FlightRepository;
import org.caglar.flightsearchapi.utils.DateUtil;
import org.caglar.flightsearchapi.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    FlightRepository flightRepository;
    AirportRepository airportRepository;

    @Autowired
    FlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    public FlightDTO save(FlightDTO flightDTO, String departureAirport, String arrivalAirport) throws InvalidDateException, InvalidPriceException, AirportNotFoundException {

        flightDTO.setDepartureAirport(airportRepository.findByCityCode(departureAirport));
        flightDTO.setArrivalAirport(airportRepository.findByCityCode(arrivalAirport));

        if(flightDTO.getDepartureAirport() != null && flightDTO.getArrivalAirport() != null){
            Flight flight = MapperUtil.instance().map(flightDTO, Flight.class);
            if(flight != null){
                if(DateUtil.isFlightValid(flight)){
                    flightRepository.save(flight);
                    return flightDTO;
                }
            }
        }
        throw new AirportNotFoundException("Invalid airport name: " + departureAirport + " - " + arrivalAirport);
    }
}
