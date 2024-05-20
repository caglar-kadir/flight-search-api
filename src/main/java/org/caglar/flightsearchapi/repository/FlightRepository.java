package org.caglar.flightsearchapi.repository;

import org.caglar.flightsearchapi.models.Airport;
import org.caglar.flightsearchapi.models.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface FlightRepository extends Repository<Flight, UUID> {
    Flight save(Flight flight);

    Flight getById(UUID id);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDate(Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDate);

    @Query(value = "SELECT f FROM Flight f WHERE f.departureDate = :startDate AND f.arrivalDate = :endDate AND f.departureAirport = :departure AND f.arrivalAirport = :arrival")
    List<Flight> findByDatesAndAirports(LocalDateTime startDate, LocalDateTime endDate, Airport departure, Airport arrival);
}
