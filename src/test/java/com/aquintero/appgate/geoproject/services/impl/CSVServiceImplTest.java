package com.aquintero.appgate.geoproject.services.impl;

import com.aquintero.appgate.geoproject.converter.FromGeolocationListDtoToGeolocationList;
import com.aquintero.appgate.geoproject.domain.response.InfoResponse;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import com.aquintero.appgate.geoproject.entities.Geolocation;
import com.aquintero.appgate.geoproject.exception.NoCsvFormatException;
import com.aquintero.appgate.geoproject.exception.constants.ErrorMessageHelper;
import com.aquintero.appgate.geoproject.helper.CSVHelper;
import com.aquintero.appgate.geoproject.repository.GeolocationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Class CSVServiceImplTest
 * @author aquintero
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CSVServiceImplTest
{

    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private FromGeolocationListDtoToGeolocationList fromGeolocationListDtoToGeolocationList;
    @Mock
    private GeolocationRepository geolocationRepository;
    @InjectMocks
    private CSVServiceImpl csvServiceImpl;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTest() throws IOException {

        String csvInput =
                "IpFrom;IpTo;CountryCode;Country;Region;City;Latitude;Longitude;TimeZone\n" +
                        "192.168.24.21;192.168.24.50;US;UNITED STATES;REGION 1;CALIFORNIA;41.8434;-87.7633;UTC";
        MockMultipartFile file =
                new MockMultipartFile(
                        "file",
                        "test.csv",
                        "text/csv",
                        csvInput.getBytes(StandardCharsets.UTF_8));
        List<GeolocationDto> geolocationsDto = CSVHelper.csvToTutorials(file.getInputStream());
        List<Geolocation> geolocations = new ArrayList<>();
        when(fromGeolocationListDtoToGeolocationList.convert(geolocationsDto)).thenReturn(geolocations);
        when(geolocationRepository.saveAll(geolocations)).thenReturn(geolocations);
        InfoResponse infoResponse = csvServiceImpl.save(file);
        assertEquals("Uploaded the file successfully: " + file.getOriginalFilename(), infoResponse.getMessage(),
                "It should be 200");

    }

    @Test
    void saveThrownNoCsvFormatExceptionTest() throws IOException
    {
        try {
            String csvInput =
                    "IpFrom;IpTo;CountryCode;Country;Region;City;Latitude;Longitude;TimeZone\n" +
                            "192.168.24.21;192.168.24.50;US;UNITED STATES;REGION 1;CALIFORNIA;41.8434;-87.7633;UTC";
            MockMultipartFile file =
                    new MockMultipartFile(
                            "test",
                            "test.csv",
                            "text/pdf",
                            csvInput.getBytes(StandardCharsets.UTF_8));
            List<GeolocationDto> geolocationsDto = CSVHelper.csvToTutorials(file.getInputStream());
            List<Geolocation> geolocations = new ArrayList<>();
            when(fromGeolocationListDtoToGeolocationList.convert(geolocationsDto)).thenReturn(geolocations);
            when(geolocationRepository.saveAll(geolocations)).thenReturn(geolocations);
            csvServiceImpl.save(file);
        }catch (NoCsvFormatException ex) {
            assertEquals(ErrorMessageHelper.NO_CSV_FORMAT, ex.getMessage(),
                    "It should be " + ErrorMessageHelper.NO_CSV_FORMAT);
        }



    }
}
