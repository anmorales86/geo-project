package com.aquintero.appgate.geoproject.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeolocationDto
{

    private Long id;
    private Long ipFrom;
    private Long ipTo;
    private String countryCode;
    private String country;
    private String region;
    private String city;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private Date timeZone;

}
