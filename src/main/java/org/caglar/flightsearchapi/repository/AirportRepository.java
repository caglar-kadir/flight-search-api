package org.caglar.flightsearchapi.repository;

import org.caglar.flightsearchapi.models.Airport;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface AirportRepository extends Repository<Airport, UUID> {
    Airport save(Airport airport);

    Airport findByCityCode(String cityCode);
}
