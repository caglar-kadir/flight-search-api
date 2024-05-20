package org.caglar.flightsearchapi.utils;

import org.caglar.flightsearchapi.exceptions.InvalidDateException;
import org.caglar.flightsearchapi.exceptions.InvalidPriceException;
import org.caglar.flightsearchapi.models.Flight;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private DateUtil() {
    }

    public static boolean isFlightValid(Flight flight) throws InvalidDateException, InvalidPriceException {
        if (flight.getDepartureDate() == null || flight.getArrivalDate() == null) {
            throw new InvalidDateException("Date cannot be null.");
        }
        if (isValidDate(flight.getDepartureDate()) || isValidDate(flight.getArrivalDate())) {
            throw new InvalidDateException("Invalid date.");
        }
        if (!isDepartureDateBeforeArrivalDate(flight.getDepartureDate(), flight.getArrivalDate())) {
            throw new InvalidDateException("Departure date cannot be later than arrival date");
        }
        if (flight.getPrice() < 0) {
            throw new InvalidPriceException("Invalid price.");
        }
        return true;
    }

    public static LocalDateTime convertStringToDate(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    private static boolean isValidDate(LocalDateTime date) {
        return date.isBefore(LocalDateTime.now());
    }

    private static boolean isDepartureDateBeforeArrivalDate(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        return departureDate.isBefore(arrivalDate);
    }
}
