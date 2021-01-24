package com.aquintero.appgate.geoproject.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="geolocation")
public class Geolocation
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ip_from")
    private Long ipFrom;
    @Column(name = "ip_to")
    private Long ipTo;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country")
    private String country;
    @Column(name = "region")
    private String region;
    @Column(name = "city")
    private String city;
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;
    @Column(name = "time_zone")
    private Date timeZone;

}
