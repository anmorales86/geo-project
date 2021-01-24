package com.aquintero.appgate.geoproject.converter;

import com.aquintero.appgate.geoproject.entities.Geolocation;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class FromGeolocationToGeolocationDto implements Converter<Geolocation, GeolocationDto>
{

    private final ModelMapper modelMapper;

    public FromGeolocationToGeolocationDto(final ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

    @Override
    public GeolocationDto convert(Geolocation source)
    {
        return modelMapper.map(source, GeolocationDto.class);
    }
}
