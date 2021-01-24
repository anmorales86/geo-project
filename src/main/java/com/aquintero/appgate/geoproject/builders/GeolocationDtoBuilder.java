package com.aquintero.appgate.geoproject.builders;

import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import com.aquintero.appgate.geoproject.utils.IpUtil;
import org.apache.commons.csv.CSVRecord;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

public class GeolocationDtoBuilder
{

    public static GeolocationDto build(CSVRecord data) {
        GeolocationDto geolocationDto = new GeolocationDto(
                null,
                IpUtil.resetIpToDecimal(data.get("IpFrom")),
                IpUtil.resetIpToDecimal(data.get("IpTo")),
                data.get("CountryCode"),
                data.get("Country"),
                data.get("Region"),
                data.get("City"),
                new BigDecimal(data.get("Latitude")),
                new BigDecimal(data.get("Longitude")),
                Calendar.getInstance(TimeZone.getTimeZone(data.get("TimeZone"))).getTime());
        return geolocationDto;
    }

}
