package dev.erwin.samples.shopservice.service;

import dev.erwin.samples.shopservice.dto.ProductDTO;
import dev.erwin.samples.shopservice.entity.Product;
import dev.erwin.samples.shopservice.repository.ProductRepository;
import dev.erwin.samples.shopservice.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductDTO> getProductById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent()) {
            ProductDTO productDTO = Converter.toDTO(product.get());
            return Optional.of(productDTO);
        }
        return Optional.empty();
    }

    public ProductDTO create(ProductDTO productDTO) {
        Product product = Converter.toEntity(productDTO);
        Product newProduct = productRepository.save(product);
        return Converter.toDTO(newProduct);
    }


    public Page<ProductDTO> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productList = this.productRepository.findAll(pageable);
        return new PageImpl<>(productList.stream().map(Converter::toDTO).toList(), pageable, productList.getTotalElements());
    }

    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }

    public Optional<ProductDTO> getProductByName(String name) {
        Optional<Product> product = this.productRepository.findByName(name);
        if (product.isPresent()) {
            ProductDTO productDTO = Converter.toDTO(product.get());
            return Optional.of(productDTO);
        }
        return Optional.empty();
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = Converter.toEntity(productDTO);
        Product updatedProduct = productRepository.save(product);
        return Converter.toDTO(updatedProduct);
    }


    public List<ProductDTO> getProductByDescription(String desc) {
        return productRepository.findByDescriptionContainingIgnoreCase(desc).stream().map(Converter::toDTO).toList();
    }
}
