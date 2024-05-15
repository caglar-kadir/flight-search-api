package org.caglar.flightsearchapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "flights", schema = "fl")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private long id;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "departure_airport")
    @JsonIgnore
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport")
    @JsonIgnore
    private Airport arrivalAirport;

}
