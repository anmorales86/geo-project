package com.aquintero.appgate.geoproject.controller;

import com.aquintero.appgate.geoproject.domain.response.InfoResponse;
import com.aquintero.appgate.geoproject.services.ICSVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/csv")
@Slf4j
public class CSVController
{

    private final ICSVService icsvService;

    @Autowired
    public CSVController(final ICSVService icsvService) {
        this.icsvService = icsvService;
    }

    @PostMapping("/v1/upload")
    public ResponseEntity<InfoResponse> uploadFile(@RequestParam("file") MultipartFile file) throws IOException
    {
            return new ResponseEntity<>(icsvService.save(file), HttpStatus.OK);
    }

}
