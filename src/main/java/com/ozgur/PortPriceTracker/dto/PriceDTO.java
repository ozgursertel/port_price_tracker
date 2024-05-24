package com.ozgur.PortPriceTracker.dto;

import com.ozgur.PortPriceTracker.entities.Container;
import com.ozgur.PortPriceTracker.entities.Port;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

public class PriceDTO {
    private long id;
    private PortDTO portOfDischarge;
    private PortDTO portOfLoading;
    private CarrierDTO carrier;
    private float freightPrice;
    private float localPrice;
    private Date priceValidityDate;
    private Date createdDate;

    private Container containerType;

    public Container getContainerType() {
        return containerType;
    }

    public void setContainerType(Container containerType) {
        this.containerType = containerType;
    }

    public PriceDTO() {
    }

    public PriceDTO(long id, PortDTO portOfDischarge, PortDTO portOfLoading, CarrierDTO carrier, float freightPrice, float localPrice, Date priceValidityDate, Date createdDate, Container containerType) {
        this.id = id;
        this.portOfDischarge = portOfDischarge;
        this.portOfLoading = portOfLoading;
        this.carrier = carrier;
        this.freightPrice = freightPrice;
        this.localPrice = localPrice;
        this.priceValidityDate = priceValidityDate;
        this.createdDate = createdDate;
        this.containerType = containerType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PortDTO getPortOfDischarge() {
        return portOfDischarge;
    }

    public void setPortOfDischarge(PortDTO portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }

    public PortDTO getPortOfLoading() {
        return portOfLoading;
    }

    public void setPortOfLoading(PortDTO portOfLoading) {
        this.portOfLoading = portOfLoading;
    }

    public CarrierDTO getCarrier() {
        return carrier;
    }

    public void setCarrier(CarrierDTO carrier) {
        this.carrier = carrier;
    }

    public float getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(float freightPrice) {
        this.freightPrice = freightPrice;
    }

    public float getLocalPrice() {
        return localPrice;
    }

    public void setLocalPrice(float localPrice) {
        this.localPrice = localPrice;
    }

    public Date getPriceValidityDate() {
        return priceValidityDate;
    }

    public void setPriceValidityDate(Date priceValidityDate) {
        this.priceValidityDate = priceValidityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}