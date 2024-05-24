package com.ozgur.PortPriceTracker.controller;

import com.ozgur.PortPriceTracker.dto.CarrierDTO;
import com.ozgur.PortPriceTracker.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/carrier")
public class CarrierController {
    @Autowired
    private CarrierService carrierService;

    //Get all
    @GetMapping
    private ResponseEntity<List<CarrierDTO>> getAll(){
        return ResponseEntity.ok(carrierService.getAll());
    }
    //Get by id
    @GetMapping("/{id}")
    private ResponseEntity<CarrierDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(carrierService.findById(id));
    }
    //Add Carrier
    @PostMapping
    private ResponseEntity<CarrierDTO> addCarrier(@RequestBody CarrierDTO dto){
        return ResponseEntity.ok(carrierService.addCarrier(dto));
    }
    //Update Carrier
    @PutMapping("/{id}")
    private ResponseEntity<CarrierDTO> updateById(@PathVariable Long id,@RequestBody CarrierDTO dto){
        return ResponseEntity.ok(carrierService.updateById(dto,id));
    }
    //Delete Carrier
    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteById(@PathVariable Long id){
        carrierService.deleteById(id);
        String str = id+":ID Deleted Succesfully" ;
        return ResponseEntity.ok(str);
    }
}
