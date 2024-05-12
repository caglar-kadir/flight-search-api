package org.caglar.flightsearchapi.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "airports", schema = "fl")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id")
    private Long id;

    @Column(name = "city")
    private String city;
}
