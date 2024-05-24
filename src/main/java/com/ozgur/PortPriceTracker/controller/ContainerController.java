package com.ozgur.PortPriceTracker.controller;

import com.ozgur.PortPriceTracker.dto.ContainerDTO;
import com.ozgur.PortPriceTracker.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/containers")
public class ContainerController {
    @Autowired
    private ContainerService containerService;

    //Get all
    @GetMapping
    private ResponseEntity<List<ContainerDTO>> getAll(){
        return ResponseEntity.ok(containerService.getAll());
    }
    //Get by id
    @GetMapping("/{id}")
    private ResponseEntity<ContainerDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(containerService.findById(id));
    }

}
