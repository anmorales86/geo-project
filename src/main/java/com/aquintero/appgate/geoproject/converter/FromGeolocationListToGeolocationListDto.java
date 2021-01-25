package com.aquintero.appgate.geoproject.converter;

import com.aquintero.appgate.geoproject.entities.Geolocation;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.List;

@Getter
@Setter
@Component
public class FromGeolocationListToGeolocationListDto implements Converter<List<Geolocation>, List<GeolocationDto>>
{

    private final ModelMapper modelMapper;

    @Autowired
    public FromGeolocationListToGeolocationListDto(final ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GeolocationDto> convert(List<Geolocation> source) {
        return modelMapper.map(source, new TypeToken<List<GeolocationDto>>(){}.getType());
    }
}
