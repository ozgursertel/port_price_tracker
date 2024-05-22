package com.ozgur.PortPriceTracker.mapper;

import com.ozgur.PortPriceTracker.dto.CarrierDTO;
import com.ozgur.PortPriceTracker.entities.Carrier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CarrierMapper extends GenericMapper<CarrierDTO, Carrier> {
    CarrierMapper INSTANCE = Mappers.getMapper(CarrierMapper.class);
}
