package com.aquintero.appgate.geoproject.services;

import com.aquintero.appgate.geoproject.dto.GeolocationDto;

import java.util.List;

public interface IGeoService
{

    List<GeolocationDto> getGeolocations(String ip);

}
