package org.caglar.flightsearchapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "flights", schema = "fl")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "flight_id")
    private UUID id;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "departure_airport")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport")
    private Airport arrivalAirport;

}
