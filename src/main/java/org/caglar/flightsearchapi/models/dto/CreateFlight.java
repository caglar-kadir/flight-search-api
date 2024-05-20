package org.caglar.flightsearchapi.models.dto;

import java.time.LocalDateTime;

public record CreateFlight(LocalDateTime departureDate, LocalDateTime arrivalDate, double price){}