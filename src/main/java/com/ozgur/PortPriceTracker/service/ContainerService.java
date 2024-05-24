package com.ozgur.PortPriceTracker.service;
import com.ozgur.PortPriceTracker.dto.ContainerDTO;
import com.ozgur.PortPriceTracker.mapper.ContainerMapper;
import com.ozgur.PortPriceTracker.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {
    @Autowired
    private ContainerRepository containerRepository;

    //Get All
    public List<ContainerDTO> getAll(){
        return ContainerMapper.INSTANCE.toDtoList(
                containerRepository.findAll()
        );
    }
    //Get By ID
    public ContainerDTO findById(Long id){
        return ContainerMapper.INSTANCE.toDto(containerRepository.findById(id).orElseThrow(()-> new RuntimeException(id+":ID didnt found in Container Repo")));
    }
}

