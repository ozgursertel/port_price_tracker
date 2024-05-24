package com.ozgur.PortPriceTracker.dto;

public class ContainerDTO {
    private Long id;
    private String type;

    public ContainerDTO(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public ContainerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
