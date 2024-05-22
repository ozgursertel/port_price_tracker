package com.ozgur.PortPriceTracker.mapper;

import com.ozgur.PortPriceTracker.dto.CountryDTO;
import com.ozgur.PortPriceTracker.entities.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CountryMapper extends GenericMapper<CountryDTO, Country> {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
}
