package com.aquintero.appgate.geoproject.helper;

import com.aquintero.appgate.geoproject.builders.GeolocationDtoBuilder;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class CSVHelper
 */
public class CSVHelper
{
  public static String TYPE = "text/csv";

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) { return false; }
    return true;
  }

  public static List<GeolocationDto> csvToTutorials(InputStream is)
  {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()))
        {
              List<GeolocationDto> geolocationDtoList = new ArrayList<>();
              Iterable<CSVRecord> csvRecords = csvParser.getRecords();
              csvRecords.forEach(data -> {
                  GeolocationDto geolocationDto = GeolocationDtoBuilder.build(data);
                  geolocationDtoList.add(geolocationDto);
              });
              return geolocationDtoList;
        } catch (IOException e) {
          throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
  }




}
