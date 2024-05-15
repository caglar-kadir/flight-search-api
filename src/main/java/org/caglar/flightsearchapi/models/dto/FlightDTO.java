package org.caglar.flightsearchapi.models.dto;

import lombok.Data;
import org.caglar.flightsearchapi.models.Airport;

import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private double price;
    private Airport departureAirport;
    private Airport arrivalAirport;
}
