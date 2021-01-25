package com.aquintero.appgate.geoproject.controller;

import com.aquintero.appgate.geoproject.domain.response.InfoResponse;
import com.aquintero.appgate.geoproject.services.ICSVService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CSVControllerTest
{

    @Mock
    private ICSVService icsvService;
    @InjectMocks
    private CSVController csvController;

    private InfoResponse infoResponse;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        resetInfoResponse();
    }

    private void resetInfoResponse()
    {
        this.infoResponse = new InfoResponse();
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
        this.infoResponse.setMessage("Uploaded the file successfully: " + file.getOriginalFilename());
        when(icsvService.save(file)).thenReturn(this.infoResponse);
        ResponseEntity responseEntity = csvController.uploadFile(file);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(),"It should be 200");

    }

}
