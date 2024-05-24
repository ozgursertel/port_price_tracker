package com.ozgur.PortPriceTracker.service;

import com.ozgur.PortPriceTracker.dto.CityDTO;
import com.ozgur.PortPriceTracker.dto.CountryDTO;
import com.ozgur.PortPriceTracker.entities.Country;
import com.ozgur.PortPriceTracker.mapper.CityMapper;
import com.ozgur.PortPriceTracker.mapper.CountryMapper;
import com.ozgur.PortPriceTracker.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDTO> getAll() {
        return CountryMapper.INSTANCE.toDtoList(countryRepository.findAll());
    }

    public CountryDTO findByName(String name) {
        return CountryMapper.INSTANCE.toDto(countryRepository.findByName(name).orElseThrow(() -> new RuntimeException(name + " country did not Found")));
    }

    public CountryDTO findById(Long id){
        return CountryMapper.INSTANCE.toDto(countryRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " :ID country did not Found")));
    }

    public CountryDTO save(CountryDTO dto){
        return CountryMapper.INSTANCE.toDto(countryRepository.save(CountryMapper.INSTANCE.toEntity(dto)));
    }

    public CountryDTO update(CountryDTO dto,Long id){
        Country e = countryRepository.findById(id).orElseThrow(()->new RuntimeException(dto.getId()+" :ID Did not found"));
        CountryMapper.INSTANCE.updateEntityFromDto(dto,e);
        return CountryMapper.INSTANCE.toDto(countryRepository.save(e));
    }

    public void delete(Long id){
        countryRepository.delete(countryRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " :ID Country did not Found")));
    }

    public List<CityDTO> findCitiesById(Long id) {
        Country e = countryRepository.findById(id).orElseThrow(()->new RuntimeException(id + ":ID is not found in Countries"));
        return CityMapper.INSTANCE.toDtoList(e.getCityList());
    }
}
