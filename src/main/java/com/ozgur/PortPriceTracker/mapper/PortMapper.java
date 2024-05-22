package com.ozgur.PortPriceTracker.mapper;

import com.ozgur.PortPriceTracker.dto.PortDTO;
import com.ozgur.PortPriceTracker.entities.Port;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PortMapper extends GenericMapper<PortDTO, Port> {
    PortMapper INSTANCE = Mappers.getMapper(PortMapper.class);

}
