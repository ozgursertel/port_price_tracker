package com.ozgur.PortPriceTracker.controller;

import com.ozgur.PortPriceTracker.dto.CityDTO;
import com.ozgur.PortPriceTracker.dto.CountryDTO;
import com.ozgur.PortPriceTracker.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/country")
public class CountryController {
    @Autowired
    private CountryService countryService;
    //Get All
    @GetMapping
    public ResponseEntity<List<CountryDTO>> findAll(){
        return ResponseEntity.ok(countryService.getAll());
    }
    //Get Country By ID
    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> findCountryById(@PathVariable Long id){
        return ResponseEntity.ok(countryService.findById(id));
    }
    //Update Port By ID
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> updateCountryById(@PathVariable Long id,@RequestBody CountryDTO dto){
        return ResponseEntity.ok(countryService.update(dto,id));
    }
    //Add Port
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CountryDTO> addCountry(@RequestBody CountryDTO dto){
        return ResponseEntity.ok(countryService.save(dto));
    }

    //Delete Port
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id){
        countryService.delete(id);
        return ResponseEntity.ok(id+" :ID is deleted successfully !");
    }

    @GetMapping("/{id}/cities")
    public ResponseEntity<List<CityDTO>> findCitiesById(@PathVariable Long id){
        return  ResponseEntity.ok(countryService.findCitiesById(id));
    }
}
