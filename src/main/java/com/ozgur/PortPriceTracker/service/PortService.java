package com.ozgur.PortPriceTracker.service;

import com.ozgur.PortPriceTracker.dto.PortDTO;
import com.ozgur.PortPriceTracker.entities.City;
import com.ozgur.PortPriceTracker.entities.Port;
import com.ozgur.PortPriceTracker.mapper.PortMapper;
import com.ozgur.PortPriceTracker.repository.CityRepository;
import com.ozgur.PortPriceTracker.repository.PortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortService {
    @Autowired
    private PortRepository portRepository;
    @Autowired
    private CityRepository cityRepository;

    public List<PortDTO> getAll() {
        return PortMapper.INSTANCE.toDtoList(portRepository.findAll());
    }

    public PortDTO findPortByName(String name) {
        return PortMapper.INSTANCE.toDto(portRepository.findByName(name).orElseThrow(() -> new RuntimeException(name + " port did not Found")));
    }

    public PortDTO findPortById(Long id){
        return PortMapper.INSTANCE.toDto(portRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " :ID port did not Found")));
    }

    public PortDTO save(PortDTO dto){
        return PortMapper.INSTANCE.toDto(portRepository.save(PortMapper.INSTANCE.toEntity(dto)));
    }

    public PortDTO update(PortDTO dto,Long id){
        Port e = portRepository.findById(id).orElseThrow(()->new RuntimeException(dto.getId()+" :ID Did not found"));
        PortMapper.INSTANCE.updateEntityFromDto(dto,e);
        return PortMapper.INSTANCE.toDto(portRepository.save(e));
    }

    public void delete(Long id){
        portRepository.delete(portRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " :ID port did not Found")));
    }

    public PortDTO updateCity(Long cityID, Long portID) {
        Port e = portRepository.findById(portID).orElseThrow(() -> new RuntimeException(portID + " :ID port did not Found"));
        City c = cityRepository.findById(cityID).orElseThrow(() -> new RuntimeException(cityID + " :ID city did not Found"));
        e.setCity(c);
        return PortMapper.INSTANCE.toDto(portRepository.save(e));
    }
}
