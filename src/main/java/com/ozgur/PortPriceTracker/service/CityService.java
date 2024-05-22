package com.ozgur.PortPriceTracker.service;
import com.ozgur.PortPriceTracker.dto.CityDTO;
import com.ozgur.PortPriceTracker.entities.City;
import com.ozgur.PortPriceTracker.entities.Country;
import com.ozgur.PortPriceTracker.mapper.CityMapper;
import com.ozgur.PortPriceTracker.repository.CityRepository;
import com.ozgur.PortPriceTracker.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;

    public List<CityDTO> getAll() {
        return CityMapper.INSTANCE.toDtoList(cityRepository.findAll());
    }

    public CityDTO findByName(String name) {
        return CityMapper.INSTANCE.toDto(cityRepository.findByName(name).orElseThrow(() -> new RuntimeException(name + " city did not Found")));
    }

    public CityDTO findById(Long id){
        return CityMapper.INSTANCE.toDto(cityRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " :ID city did not Found")));
    }

    public CityDTO save(CityDTO dto){
        return CityMapper.INSTANCE.toDto(cityRepository.save(CityMapper.INSTANCE.toEntity(dto)));
    }

    public CityDTO update(CityDTO dto,Long id){
        City e = cityRepository.findById(id).orElseThrow(()->new RuntimeException(dto.getId()+" :ID Did not found"));
        CityMapper.INSTANCE.updateEntityFromDto(dto,e);
        return CityMapper.INSTANCE.toDto(cityRepository.save(e));
    }

    public void delete(Long id){
        cityRepository.delete(cityRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " :ID City did not Found")));
    }

    public CityDTO updateCountry(Long cityID, Long countryID) {
        City c = cityRepository.findById(cityID).orElseThrow(() -> new RuntimeException(cityID + " :ID city did not Found"));
        Country co = countryRepository.findById(countryID).orElseThrow(() -> new RuntimeException(countryID + " :ID country did not Found"));
        c.setCountry(co);
        return CityMapper.INSTANCE.toDto(cityRepository.save(c));
    }
}
