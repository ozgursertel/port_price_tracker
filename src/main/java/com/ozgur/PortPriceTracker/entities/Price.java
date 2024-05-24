package com.ozgur.PortPriceTracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "pod_id", referencedColumnName = "id")
    private Port portOfDischarge;
    @ManyToOne
    @JoinColumn(name = "pol_id", referencedColumnName = "id")
    private Port portOfLoading;
    @ManyToOne
    @JoinColumn(name = "carrier_id", referencedColumnName = "id")
    private Carrier carrier;
    @Column(name = "freight_price")
    private float freightPrice;
    @Column(name = "local_price")
    private float localPrice;
    @Column(name = "price_validity_date")
    private Date priceValidityDate;
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "container_type_id",referencedColumnName = "id")
    private Container containerType;
    public Price(long id, Port portOfDischarge, Port portOfLoading, Carrier carrier, float freightPrice, float localPrice, Date priceValidityDate, Date createdDate) {
        this.id = id;
        this.portOfDischarge = portOfDischarge;
        this.portOfLoading = portOfLoading;
        this.carrier = carrier;
        this.freightPrice = freightPrice;
        this.localPrice = localPrice;
        this.priceValidityDate = priceValidityDate;
        this.createdDate = createdDate;
    }
    public Price() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Port getPortOfDischarge() {
        return portOfDischarge;
    }
    public void setPortOfDischarge(Port portOfDischarge) {
        this.portOfDischarge = portOfDischarge;
    }
    public Port getPortOfLoading() {
        return portOfLoading;
    }
    public void setPortOfLoading(Port portOfLoading) {
        this.portOfLoading = portOfLoading;
    }
    public Carrier getCarrier() {
        return carrier;
    }
    public void setCarrier(Carrier carrier) {
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

    public Container getContainerType() {
        return containerType;
    }

    public void setContainerType(Container containerType) {
        this.containerType = containerType;
    }
}