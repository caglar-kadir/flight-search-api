package org.caglar.flightsearchapi.models.dto;

import org.caglar.flightsearchapi.models.Airport;

import java.time.LocalDateTime;

public record ReturnFlight (LocalDateTime departureDate, LocalDateTime arrivalDate, double price, Airport departureAirport, Airport arrivalAirport){}
