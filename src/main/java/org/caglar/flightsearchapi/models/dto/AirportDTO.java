package org.caglar.flightsearchapi.models.dto;

import lombok.Data;
import org.caglar.flightsearchapi.models.Flight;

import java.util.List;

@Data
public class AirportDTO {
    private String cityCode;
    private String city;
}
