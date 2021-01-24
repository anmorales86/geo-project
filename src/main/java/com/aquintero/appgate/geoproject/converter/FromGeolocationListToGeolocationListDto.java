package com.aquintero.appgate.geoproject.converter;

import com.aquintero.appgate.geoproject.entities.Geolocation;
import com.aquintero.appgate.geoproject.dto.GeolocationDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class FromGeolocationListToGeolocationListDto implements Converter<List<GeolocationDto>, List<Geolocation>>
{

    private final ModelMapper modelMapper;

    public FromGeolocationListToGeolocationListDto(final ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Geolocation> convert(List<GeolocationDto> source) {
        return modelMapper.map(source, new TypeToken<List<Geolocation>>(){}.getType());
    }
}
