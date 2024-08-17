package dev.erwin.samples.shopservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ProductDTO implements Serializable {
    private Integer id;
    private String name;
    private String manufacturer;
    private String description;
    private List<ProductImageLocationDTO> locations;

    public ProductDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocations(List<ProductImageLocationDTO> locations) {
        this.locations = locations;
    }
}
