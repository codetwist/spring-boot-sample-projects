package dev.erwin.samples.shopservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProductImageLocationDTO implements Serializable {
    private Long id;
    private String url;

    public ProductImageLocationDTO() {

    }

}
