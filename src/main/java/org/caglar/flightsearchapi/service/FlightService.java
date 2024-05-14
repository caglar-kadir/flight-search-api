package org.caglar.flightsearchapi.service;

import org.caglar.flightsearchapi.exceptions.InvalidDateException;
import org.caglar.flightsearchapi.exceptions.InvalidPriceException;
import org.caglar.flightsearchapi.models.Flight;
import org.caglar.flightsearchapi.repository.FlightRepository;
import org.caglar.flightsearchapi.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    FlightRepository flightRepository;

    FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight save(Flight flight) throws Exception {
        if(isFlightValid(flight)){
            return flightRepository.save(flight);
        }
        throw new Exception("Unsuccessful process.");
    }
    public List<Flight> saveAll(List<Flight> flights) {
        return flights.stream().filter(flight -> {
            try {
                return isFlightValid(flight);
            } catch (InvalidDateException | InvalidPriceException e) {
                throw new RuntimeException(e);
            }
        }).map(flight -> flightRepository.save(flight)).toList();
    }

    private boolean isFlightValid(Flight flight) throws InvalidDateException, InvalidPriceException {
        if(flight.getDepartureDate().isEmpty() || flight.getArrivalDate().isEmpty()){
            throw new InvalidDateException("Date cannot be null.");
        }
        if (!DateUtil.isValidDate(flight.getDepartureDate()) || !DateUtil.isValidDate(flight.getArrivalDate())) {
            throw new InvalidDateException("Invalid date.");
        }
        if(!DateUtil.isDepartureDateAfterArrivalDate(flight.getDepartureDate(), flight.getArrivalDate())){
            throw new InvalidDateException("Departure date cannot be later than arrival date");
        }
        if (flight.getPrice() < 0) {
            throw new InvalidPriceException("Invalid price.");
        }
        return true;
    }
}
