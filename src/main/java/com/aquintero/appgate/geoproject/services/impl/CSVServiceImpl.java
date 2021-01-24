package com.aquintero.appgate.geoproject.services.impl;

import com.aquintero.appgate.geoproject.converter.FromGeolocationListDtoToGeolocationList;
import com.aquintero.appgate.geoproject.entities.Geolocation;
import com.aquintero.appgate.geoproject.domain.response.InfoResponse;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import com.aquintero.appgate.geoproject.exception.NoCsvFormatException;
import com.aquintero.appgate.geoproject.helper.CSVHelper;
import com.aquintero.appgate.geoproject.repository.GeolocationRepository;
import com.aquintero.appgate.geoproject.services.ICSVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class CSVServiceImpl implements ICSVService
{

    private final GeolocationRepository geolocationRepository;
    private final FromGeolocationListDtoToGeolocationList fromGeolocationListDtoToGeolocationList;

    @Autowired
    public CSVServiceImpl(final GeolocationRepository geolocationRepository,
                          final FromGeolocationListDtoToGeolocationList fromGeolocationListDtoToGeolocationList)

    {
        this.geolocationRepository = geolocationRepository;
        this.fromGeolocationListDtoToGeolocationList = fromGeolocationListDtoToGeolocationList;
    }

    @Override
    public InfoResponse save(MultipartFile file) throws IOException
    {
        if (!CSVHelper.hasCSVFormat(file)) {
            throw new NoCsvFormatException();
        }
        List<GeolocationDto> tutorialsDto = CSVHelper.csvToTutorials(file.getInputStream());
        List<Geolocation> geolocations = this.fromGeolocationListDtoToGeolocationList.convert(tutorialsDto);
        geolocationRepository.saveAll(geolocations);
        return new InfoResponse("Uploaded the file successfully: " + file.getOriginalFilename());
    }

}
