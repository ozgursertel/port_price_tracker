package com.ozgur.PortPriceTracker.mapper;

import com.ozgur.PortPriceTracker.dto.CityDTO;
import com.ozgur.PortPriceTracker.entities.City;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CityMapper extends GenericMapper<CityDTO, City> {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
}
