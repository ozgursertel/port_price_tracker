package com.ozgur.PortPriceTracker.dto;

import com.ozgur.PortPriceTracker.entities.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CityDTO {
    private long id;
    private String name;
    private CountryDTO country;

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

    public CountryDTO getCountry() {
        return country;
    }

    public CityDTO() {
    }

    public CityDTO(long id, String name, CountryDTO country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }
}
