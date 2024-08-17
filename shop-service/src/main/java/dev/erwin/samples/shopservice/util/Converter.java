package dev.erwin.samples.shopservice.util;

import dev.erwin.samples.shopservice.dto.ProductDTO;
import dev.erwin.samples.shopservice.dto.ProductImageLocationDTO;
import dev.erwin.samples.shopservice.entity.Product;
import dev.erwin.samples.shopservice.entity.ProductImageLocation;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

public class Converter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setLocations(new ArrayList<>());
        if (product.getImageLocationList() != null) {
            for (ProductImageLocation location : product.getImageLocationList()) {
                ProductImageLocationDTO imageLocationDTO = toDTO(location);
                productDTO.getLocations().add(imageLocationDTO);
            }
        }
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        product.setImageLocationList(new ArrayList<>());
        if (productDTO.getLocations() != null) {
            for (ProductImageLocationDTO productImageLocationDTO : productDTO.getLocations()) {
                ProductImageLocation imageLocation = toEntity(productImageLocationDTO);
                imageLocation.setProduct(product);
                product.getImageLocationList().add(imageLocation);
            }
        }
        return product;
    }

    public static ProductImageLocationDTO toDTO(ProductImageLocation productImageLocation) {
        return modelMapper.map(productImageLocation, ProductImageLocationDTO.class);
    }

    public static ProductImageLocation toEntity(ProductImageLocationDTO productImageLocationDTO) {
        return modelMapper.map(productImageLocationDTO, ProductImageLocation.class);
    }


}
