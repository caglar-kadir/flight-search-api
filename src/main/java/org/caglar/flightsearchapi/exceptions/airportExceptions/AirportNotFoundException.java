package org.caglar.flightsearchapi.exceptions.airportExceptions;

public class AirportNotFoundException extends Exception{
    public AirportNotFoundException(String message){
        super(message);
    }
}
