package org.caglar.flightsearchapi.repository;

import org.caglar.flightsearchapi.models.Flight;
import org.springframework.data.repository.Repository;

public interface FlightRepository extends Repository<Flight, Long> {
    Flight save(Flight flight);
}
