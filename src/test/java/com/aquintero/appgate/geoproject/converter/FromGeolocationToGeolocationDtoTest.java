package com.aquintero.appgate.geoproject.converter;

import com.aquintero.appgate.geoproject.constants.ConstantTest;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import com.aquintero.appgate.geoproject.entities.Geolocation;
import com.aquintero.appgate.geoproject.utils.IpUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FromGeolocationToGeolocationDtoTest
{

    private Geolocation geolocation;
    private GeolocationDto geolocationDto;
    private Date currentDate = new Date();

    @InjectMocks
    private ModelMapper objectMapper;
    @Mock
    private FromGeolocationToGeolocationDto fromGeolocationToGeolocationDtoMock;
    @InjectMocks
    private FromGeolocationToGeolocationDto fromGeolocationToGeolocationDto;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        resetGeolocation();
        resetGeolocationDto();
        this.fromGeolocationToGeolocationDto = new FromGeolocationToGeolocationDto(objectMapper);
    }

    private void resetGeolocation()
    {
        this.geolocation = new Geolocation(ConstantTest.GEOLOCATION_ID,
                IpUtil.resetIpToDecimal(ConstantTest.GEOLOCATION_IP_FROM),
                IpUtil.resetIpToDecimal(ConstantTest.GEOLOCATION_IP_TO),
                ConstantTest.GEOLOCATION_COUNTRY_CODE,
                ConstantTest.GEOLOCATION_COUNTRY,
                ConstantTest.GEOLOCATION_REGION,
                ConstantTest.GEOLOCATION_CITY,
                ConstantTest.GEOLOCATION_LATITUDE,
                ConstantTest.GEOLOCATION_LONGITUDE,
                currentDate);
    }

    private void resetGeolocationDto()
    {
        this.geolocationDto = new GeolocationDto(ConstantTest.GEOLOCATION_ID,
                IpUtil.resetIpToDecimal(ConstantTest.GEOLOCATION_IP_FROM),
                IpUtil.resetIpToDecimal(ConstantTest.GEOLOCATION_IP_TO),
                ConstantTest.GEOLOCATION_COUNTRY_CODE,
                ConstantTest.GEOLOCATION_COUNTRY,
                ConstantTest.GEOLOCATION_REGION,
                ConstantTest.GEOLOCATION_CITY,
                ConstantTest.GEOLOCATION_LATITUDE,
                ConstantTest.GEOLOCATION_LONGITUDE,
                currentDate);
    }

    @Test
    void fromGeolocationToGeolocationDtoToConvertTest()
    {
        when(fromGeolocationToGeolocationDtoMock.convert(this.geolocation))
                .thenReturn(this.geolocationDto);
        GeolocationDto geolocationDtoResulted = fromGeolocationToGeolocationDto.convert(this.geolocation);
        assertEquals(geolocationDto.getId(), geolocationDtoResulted.getId(),
                "It should be " + ConstantTest.GEOLOCATION_ID);
    }

}
