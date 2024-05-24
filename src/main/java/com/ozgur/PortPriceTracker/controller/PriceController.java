package com.ozgur.PortPriceTracker.controller;

import com.ozgur.PortPriceTracker.dto.PriceDTO;
import com.ozgur.PortPriceTracker.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/api/pricing")
public class PriceController {
    @Autowired
    private PriceService priceService;
    //Get All Prices
    @GetMapping
    public ResponseEntity<List<PriceDTO>> getAll(){
        return ResponseEntity.ok(priceService.getAll());
    }
    //Get Prices From Selected Ports
    @GetMapping("/ports")
    public ResponseEntity<List<PriceDTO>> getPricesFromSelectedPorts(@RequestParam Long podID,@RequestParam Long polID){
        return ResponseEntity.ok(priceService.getPricesFromSelectedPorts(podID,polID));
    }
    //Get Prices From Selected Carrier
    @GetMapping("/carrier/{id}")
    public ResponseEntity<List<PriceDTO>> getPricesFromCarrier(@PathVariable Long cId){
        return ResponseEntity.ok(priceService.getPriceFromCarrier(cId));
    }
    //Get By Id
    @GetMapping("/{id}")
    public ResponseEntity<PriceDTO> getPriceById(@PathVariable Long id){
        return ResponseEntity.ok(priceService.getPriceById(id));
    }
    //Add New Price
    @PostMapping
    public ResponseEntity<PriceDTO> addPrice(@RequestBody PriceDTO dto){
        return ResponseEntity.ok(priceService.addPrice(dto));
    }
    @PostMapping("/add")
    public ResponseEntity<PriceDTO> addPriceWithId(@RequestBody PriceDTO dto){
        return ResponseEntity.ok(priceService.addObjectWithId(dto));
    }
    //Update Selected Price
    @PutMapping("/{id}")
    public ResponseEntity<PriceDTO> updatePrice(@RequestBody PriceDTO dto,@PathVariable Long id){
        return ResponseEntity.ok(priceService.updatePrice(dto,id));
    }
    //Delete price
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrice(@PathVariable Long id){
        priceService.deletePrice(id);
        return ResponseEntity.ok(id+":ID is Deleted successfully");
    }
}
