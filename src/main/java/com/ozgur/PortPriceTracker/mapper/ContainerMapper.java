package com.ozgur.PortPriceTracker.mapper;

import com.ozgur.PortPriceTracker.dto.ContainerDTO;
import com.ozgur.PortPriceTracker.entities.Container;
import org.mapstruct.factory.Mappers;

public interface ContainerMapper extends GenericMapper<ContainerDTO, Container>{
    ContainerMapper INSTANCE = Mappers.getMapper(ContainerMapper.class);
}
