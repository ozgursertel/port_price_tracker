package com.ozgur.PortPriceTracker.controller;

import com.ozgur.PortPriceTracker.dto.PortDTO;
import com.ozgur.PortPriceTracker.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/port")
public class PortController {
    @Autowired
    private PortService portService;
    //Get All Ports
    @GetMapping
    public ResponseEntity<List<PortDTO>> findAll(){
        return ResponseEntity.ok(portService.getAll());
    }
    //Get Port By ID
    @GetMapping("/{id}")
    public ResponseEntity<PortDTO> findPortById(@PathVariable Long id){
        return ResponseEntity.ok(portService.findPortById(id));
    }
    //Update Port By ID
    @PutMapping("/{id}")
    public ResponseEntity<PortDTO> updatePortByID(@PathVariable Long id,@RequestBody PortDTO dto){
        return ResponseEntity.ok(portService.update(dto,id));
    }
    //Add Port
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<PortDTO> addPort(@RequestBody PortDTO dto){
        return ResponseEntity.ok(portService.save(dto));
    }

    //Delete Port
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deletePort(@PathVariable Long id){
        portService.delete(id);
        return ResponseEntity.ok(id+" :ID is deleted successfully !");
    }

    @PutMapping("/portToCity")
    public ResponseEntity<PortDTO> addCityToPort(@RequestParam Long cityID,@RequestParam Long portID){
        return ResponseEntity.ok(portService.updateCity(cityID,portID));
    }
}
