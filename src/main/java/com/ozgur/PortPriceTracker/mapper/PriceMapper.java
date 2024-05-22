package com.ozgur.PortPriceTracker.mapper;

import com.ozgur.PortPriceTracker.dto.PriceDTO;
import com.ozgur.PortPriceTracker.entities.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PriceMapper extends GenericMapper<PriceDTO, Price>{
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
}
