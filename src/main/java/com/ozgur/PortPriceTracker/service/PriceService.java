package com.ozgur.PortPriceTracker.service;

import com.ozgur.PortPriceTracker.dto.PriceDTO;
import com.ozgur.PortPriceTracker.entities.Carrier;
import com.ozgur.PortPriceTracker.entities.Container;
import com.ozgur.PortPriceTracker.entities.Port;
import com.ozgur.PortPriceTracker.entities.Price;
import com.ozgur.PortPriceTracker.mapper.PriceMapper;
import com.ozgur.PortPriceTracker.repository.CarrierRepository;
import com.ozgur.PortPriceTracker.repository.ContainerRepository;
import com.ozgur.PortPriceTracker.repository.PortRepository;
import com.ozgur.PortPriceTracker.repository.PriceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private PortRepository portRepository;
    @Autowired
    private CarrierRepository carrierRepository;
    @Autowired
    private ContainerRepository containerRepository;
    public List<PriceDTO> getAll() {
        return PriceMapper.INSTANCE.toDtoList(priceRepository.findAll());
    }

    public List<PriceDTO> getPricesFromSelectedPorts(Long podId,Long polId){
        return PriceMapper.INSTANCE.toDtoList(priceRepository.findByPortOfLoadingAndPortOfDischargeAndValidityDateBefore(polId,podId));
    }

    public List<PriceDTO> getPriceFromCarrier(Long cId) {
        return PriceMapper.INSTANCE.toDtoList(priceRepository.findAllByCarrierId(cId));
    }

    public PriceDTO getPriceById(Long id) {
        return PriceMapper.INSTANCE.toDto(priceRepository.findById(id).orElseThrow(()->new RuntimeException(id+":ID is not found in price")));
    }

    public PriceDTO addPrice(PriceDTO dto) {
        return PriceMapper.INSTANCE.toDto(priceRepository.save(PriceMapper.INSTANCE.toEntity(dto)));
    }

    public PriceDTO updatePrice(PriceDTO dto, Long id) {
        Price e = priceRepository.findById(id).orElseThrow(()-> new RuntimeException(id+":ID is not found in price"));
        PriceMapper.INSTANCE.updateEntityFromDto(dto,e);
        return PriceMapper.INSTANCE.toDto(priceRepository.save(e));
    }

    public void deletePrice(Long id) {
        priceRepository.delete(priceRepository.findById(id).orElseThrow(()->new RuntimeException(id+":ID is not found in price")));
    }

    public PriceDTO addObjectWithId(PriceDTO dto) {
        Port portOfDischarge = portRepository.findById(dto.getPortOfDischarge().getId())
                .orElseThrow(() -> new EntityNotFoundException("Port of Discharge not found"));
        Port portOfLoading = portRepository.findById(dto.getPortOfLoading().getId())
                .orElseThrow(() -> new EntityNotFoundException("Port of Loading not found"));
        Carrier carrier = carrierRepository.findById(dto.getCarrier().getId())
                .orElseThrow(() -> new EntityNotFoundException("Carrier not found"));
        Container container = containerRepository.findById(dto.getContainerType().getId())
                .orElseThrow(() -> new EntityNotFoundException("Carrier not found"));

        Price price = new Price();
        price.setPortOfDischarge(portOfDischarge);
        price.setPortOfLoading(portOfLoading);
        price.setCarrier(carrier);
        price.setFreightPrice(dto.getFreightPrice());
        price.setLocalPrice(dto.getLocalPrice());
        price.setPriceValidityDate(dto.getPriceValidityDate());
        price.setCreatedDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        price.setContainerType(container);
        Price savedPrice = priceRepository.save(price);

        return PriceMapper.INSTANCE.toDto(savedPrice);
    }

    public List<PriceDTO> getPricesFromSelectedPortsAndDates(Long podID, Long polID, Date fDate, Date lDate) {
        List<Price> ps = priceRepository.getPricesFromSelectedPortsAndDates(podID,polID,fDate,lDate);
        return PriceMapper.INSTANCE.toDtoList(ps);
    }
}
