package com.aquintero.appgate.geoproject.services;

import com.aquintero.appgate.geoproject.domain.response.InfoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ICSVService
{

    InfoResponse save(MultipartFile file) throws IOException;

}
