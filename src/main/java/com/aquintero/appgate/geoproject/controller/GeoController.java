package com.aquintero.appgate.geoproject.controller;

import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import com.aquintero.appgate.geoproject.services.IGeoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/geo")
@Slf4j
public class GeoController
{

    private final IGeoService iGeoService;

    @Autowired
    public GeoController(final IGeoService iGeoService)
    {
        this.iGeoService = iGeoService;
    }

    @GetMapping("/v1/geolocations")
    public ResponseEntity<List<GeolocationDto>> getGeolocations(@RequestParam("ip") String ip)
    {
        return new ResponseEntity<>(this.iGeoService.getGeolocations(ip), HttpStatus.OK);
    }

}
