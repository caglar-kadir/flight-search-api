package org.caglar.flightsearchapi.repository;

import org.caglar.flightsearchapi.models.Airport;
import org.springframework.data.repository.Repository;

public interface AirportRepository extends Repository<Airport, Long> {
    Airport save(Airport airport);

    Airport findByCityCode(String cityCode);
}
