package com.aquintero.appgate.geoproject.services.impl;

import com.aquintero.appgate.geoproject.converter.FromGeolocationListToGeolocationListDto;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import com.aquintero.appgate.geoproject.entities.Geolocation;
import com.aquintero.appgate.geoproject.exception.RecordNotFoundException;
import com.aquintero.appgate.geoproject.repository.GeolocationRepository;
import com.aquintero.appgate.geoproject.services.IGeoService;
import com.aquintero.appgate.geoproject.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class GeoServiceImpl implements IGeoService
{

    private final GeolocationRepository geolocationRepository;
    private final FromGeolocationListToGeolocationListDto fromGeolocationListToGeolocationListDto;

    @Autowired
    public GeoServiceImpl(final GeolocationRepository geolocationRepository,
                          final FromGeolocationListToGeolocationListDto fromGeolocationListToGeolocationListDto)
    {
        this.geolocationRepository = geolocationRepository;
        this.fromGeolocationListToGeolocationListDto = fromGeolocationListToGeolocationListDto;
    }

    @Override
    public List<GeolocationDto> getGeolocations(String ip)
    {
        List<Geolocation> geolocationList = this.geolocationRepository.findByBetweenIpfromAndIpto(
                IpUtil.resetIpToDecimal(ip));
        validateListIsEmpty(geolocationList);
        return this.fromGeolocationListToGeolocationListDto.convert(geolocationList);
    }

    private void validateListIsEmpty(List<Geolocation> geolocationList)
    {
        if (Objects.isNull(geolocationList) || geolocationList.isEmpty()) { throw new RecordNotFoundException(); }
    }

}
