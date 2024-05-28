package com.ozgur.PortPriceTracker.controller;

import com.ozgur.PortPriceTracker.dto.CityDTO;
import com.ozgur.PortPriceTracker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/city")
public class CityController {
    @Autowired
    private CityService cityService;
    //Get All
    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        return ResponseEntity.ok(cityService.getAll());
    }
    //Get City By ID
    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> findCityByID(@PathVariable Long id){
        return ResponseEntity.ok(cityService.findById(id));
    }
    //Update Port By ID
    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> updateCityByID(@PathVariable Long id,@RequestBody CityDTO dto){
        return ResponseEntity.ok(cityService.update(dto,id));
    }
    //Add Port
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CityDTO> addCity(@RequestBody CityDTO dto){
        return ResponseEntity.ok(cityService.save(dto));
    }

    //Delete Port
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deletePort(@PathVariable Long id){
        cityService.delete(id);
        return ResponseEntity.ok(id+" :ID is deleted successfully !");
    }

    @PutMapping("/cityToCountry")
    public ResponseEntity<CityDTO> addCityToPort(@RequestParam Long cityID,@RequestParam Long countryID){
        return ResponseEntity.ok(cityService.updateCountry(cityID,countryID));
    }

}
