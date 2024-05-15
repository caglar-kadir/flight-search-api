package org.caglar.flightsearchapi.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "airports", schema = "fl")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Long id;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departureFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivalFlights;
}
