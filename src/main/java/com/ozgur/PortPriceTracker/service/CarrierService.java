package com.ozgur.PortPriceTracker.service;

import com.ozgur.PortPriceTracker.dto.CarrierDTO;
import com.ozgur.PortPriceTracker.entities.Carrier;
import com.ozgur.PortPriceTracker.mapper.CarrierMapper;
import com.ozgur.PortPriceTracker.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierService {
    @Autowired
    private CarrierRepository carrierRepository;

    //Get All
    public List<CarrierDTO> getAll(){
       return CarrierMapper.INSTANCE.toDtoList(
               carrierRepository.findAll()
       );
    }
    //Get By ID
    public CarrierDTO findById(Long id){
        return CarrierMapper.INSTANCE.toDto(carrierRepository.findById(id).orElseThrow(()-> new RuntimeException(id+":ID didnt found in Carrier Repo")));
    }
    //Create
    public CarrierDTO addCarrier(CarrierDTO dto){
        return CarrierMapper.INSTANCE.toDto(carrierRepository.save(CarrierMapper.INSTANCE.toEntity(dto)));
    }
    //Update
    public CarrierDTO updateById(CarrierDTO dto,Long id){
        Carrier e = carrierRepository.findById(id).orElseThrow(()-> new RuntimeException(id+":ID didnt found in Carrier Reepository"));
        CarrierMapper.INSTANCE.updateEntityFromDto(dto,e);
        return CarrierMapper.INSTANCE.toDto(carrierRepository.save(e));
    }
    //Delete
    public void deleteById(Long id){
        carrierRepository.deleteById(id);
    }
}
