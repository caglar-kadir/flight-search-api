package org.caglar.flightsearchapi.service;

import org.caglar.flightsearchapi.exceptions.InvalidDateException;
import org.caglar.flightsearchapi.exceptions.InvalidPriceException;
import org.caglar.flightsearchapi.exceptions.airportExceptions.AirportNotFoundException;
import org.caglar.flightsearchapi.models.Airport;
import org.caglar.flightsearchapi.models.Flight;
import org.caglar.flightsearchapi.models.dto.CreateFlight;
import org.caglar.flightsearchapi.models.enums.AirportEnum;
import org.caglar.flightsearchapi.repository.AirportRepository;
import org.caglar.flightsearchapi.repository.FlightRepository;
import org.caglar.flightsearchapi.utils.DateUtil;
import org.caglar.flightsearchapi.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FlightService {
    FlightRepository flightRepository;
    AirportRepository airportRepository;

    @Autowired
    FlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    public Flight save(CreateFlight flightDTO, String departureAirport, String arrivalAirport) throws InvalidDateException, InvalidPriceException, AirportNotFoundException {
        checkDepartureAirport(departureAirport);
        checkArrivalAirport(arrivalAirport);
        Flight flight = MapperUtil.map(flightDTO, Flight.class);
        flight.setDepartureAirport(airportRepository.findByCityCode(departureAirport));
        flight.setArrivalAirport(airportRepository.findByCityCode(arrivalAirport));
        if (flight.getDepartureAirport() != null && flight.getArrivalAirport() != null) {
            if (DateUtil.isFlightValid(flight)) {
               return flightRepository.save(flight);
            }
        }
        return null;
    }

    public Flight getById(UUID id) {
        return flightRepository.getById(id);
    }

    public List<Flight> getByDateAndAirport(String startDate, String endDate, String departure, String arrival) throws AirportNotFoundException {
        checkDepartureAirport(departure);
        Airport departureAirport = airportRepository.findByCityCode(departure);
        Airport arrivalAirport = airportRepository.findByCityCode(arrival);
        startDate += " 00:00";
        if (endDate.isEmpty()) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDate(departureAirport, arrivalAirport, DateUtil.convertStringToDate(startDate));
        }
        checkArrivalAirport(arrival);
        endDate += " 23:59";
        return flightRepository.findByDatesAndAirports(DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate), departureAirport, arrivalAirport);
    }

    private void checkDepartureAirport(String departureAirport) throws AirportNotFoundException {
        if (!Arrays.toString(AirportEnum.values()).contains(departureAirport)) {
            throw new AirportNotFoundException("Invalid departure airport: " + departureAirport);
        }
    }

    private void checkArrivalAirport(String arrivalAirport) throws AirportNotFoundException {
        if (!Arrays.toString(AirportEnum.values()).contains(arrivalAirport)) {
            throw new AirportNotFoundException("Invalid arrival airport: " + arrivalAirport);
        }
    }
}
