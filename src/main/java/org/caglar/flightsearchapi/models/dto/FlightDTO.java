package org.caglar.flightsearchapi.models.dto;

import lombok.Data;
import org.caglar.flightsearchapi.models.Airport;

@Data
public class FlightDTO {
    private String departureDate;
    private String arrivalDate;
    private double price;
    private Airport departureAirport;
    private Airport arrivalAirport;
}
