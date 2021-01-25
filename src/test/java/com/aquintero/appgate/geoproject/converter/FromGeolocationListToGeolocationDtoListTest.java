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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FromGeolocationListToGeolocationDtoListTest
{

    private Geolocation geolocation;
    private List<Geolocation> geolocationList;
    private GeolocationDto geolocationDto;
    private List<GeolocationDto> geolocationDtoList;
    private Date currentDate = new Date();

    @InjectMocks
    private ModelMapper objectMapper;
    @Mock
    private FromGeolocationListToGeolocationListDto fromGeolocationListToGeolocationListDtoMock;
    @InjectMocks
    private FromGeolocationListToGeolocationListDto fromGeolocationListToGeolocationListDto;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        resetGeolocation();
        resetGeolocationList();
        resetGeolocationDto();
        resetGeolocationDtoList();
        this.fromGeolocationListToGeolocationListDto = new FromGeolocationListToGeolocationListDto(objectMapper);
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

    private void resetGeolocationList()
    {
        this.geolocationList = new ArrayList<>();
        this.geolocationList.add(this.geolocation);
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

    private void resetGeolocationDtoList()
    {
        this.geolocationDtoList = new ArrayList<>();
        this.geolocationDtoList.add(this.geolocationDto);
    }

    @Test
    void fromGeolocationListToGeolocationDtoListToConvertTest()
    {
        when(fromGeolocationListToGeolocationListDtoMock.convert(this.geolocationList))
                .thenReturn(this.geolocationDtoList);
        List<GeolocationDto> geolocationsDtoResulted = fromGeolocationListToGeolocationListDto.convert(this.geolocationList);
        assertEquals(this.geolocationDtoList.get(0).getId(), geolocationsDtoResulted.get(0).getId(),
                "It should be " + ConstantTest.GEOLOCATION_ID);
    }

}
