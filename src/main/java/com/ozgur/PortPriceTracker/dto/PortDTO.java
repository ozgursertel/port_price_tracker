package com.ozgur.PortPriceTracker.dto;

public class PortDTO {
    private long id;
    private String name;
    private CityDTO city;

    public String getUnLoCode() {
        return unLoCode;
    }

    public void setUnLoCode(String unLoCode) {
        this.unLoCode = unLoCode;
    }

    private String unLoCode;
    public PortDTO() {
    }

    public PortDTO(long id, String name, CityDTO city, String unLoCode) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.unLoCode = unLoCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
