package com.ozgur.PortPriceTracker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface GenericMapper<D,E> {
    GenericMapper INSTANCE = Mappers.getMapper(GenericMapper.class);

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entities);

    List<E> toEntityList(List<D> dtos);

    void updateEntityFromDto(D dto, @MappingTarget E entity);
}
