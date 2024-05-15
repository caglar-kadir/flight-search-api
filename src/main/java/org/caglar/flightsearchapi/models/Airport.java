package org.caglar.flightsearchapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private long id;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "departureAirport")
    @JsonIgnore
    private List<Flight> departureFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    @JsonIgnore
    private List<Flight> arrivalFlights;
}
