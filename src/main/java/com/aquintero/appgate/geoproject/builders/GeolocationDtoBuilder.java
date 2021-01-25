package com.aquintero.appgate.geoproject.builders;

import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import com.aquintero.appgate.geoproject.exception.IpToIncorrectException;
import com.aquintero.appgate.geoproject.utils.IpUtil;
import org.apache.commons.csv.CSVRecord;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Class GeolocationDtoBuilder
 * @author aquintero
 */
public class GeolocationDtoBuilder
{

    private static String GET_VALUE_IP_FROM = "IpFrom";
    private static String GET_VALUE_IP_TO = "IpTo";
    private static String GET_VALUE_COUNTRY_CODE = "CountryCode";
    private static String GET_VALUE_COUNTRY = "Country";
    private static String GET_VALUE_REGION = "Region";
    private static String GET_VALUE_CITY = "City";
    private static String GET_VALUE_LATITUDE = "Latitude";
    private static String GET_VALUE_LONGITUDE = "Longitude";
    private static String GET_VALUE_TIME_ZONE = "TimeZone";


    public static GeolocationDto build(CSVRecord data)
    {
        Long ipFrom = IpUtil.resetIpToDecimal(data.get(GET_VALUE_IP_FROM));
        Long ipTo = IpUtil.resetIpToDecimal(data.get(GET_VALUE_IP_TO));
        if (ipTo < ipFrom) { throw new IpToIncorrectException(); }
        GeolocationDto geolocationDto = new GeolocationDto(null,
                                                           ipFrom,
                                                           ipTo,
                                                           data.get(GET_VALUE_COUNTRY_CODE),
                                                           data.get(GET_VALUE_COUNTRY),
                                                           data.get(GET_VALUE_REGION),
                                                           data.get(GET_VALUE_CITY),
                                                           new BigDecimal(data.get(GET_VALUE_LATITUDE)),
                                                           new BigDecimal(data.get(GET_VALUE_LONGITUDE)),
                                                           Calendar.getInstance(TimeZone.getTimeZone(
                                                                   data.get(GET_VALUE_TIME_ZONE))).getTime());
        return geolocationDto;
    }

}
