package dev.erwin.samples.shopservice.controller;

import dev.erwin.samples.shopservice.dto.ProductDTO;
import dev.erwin.samples.shopservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class    ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping({"/", ""})
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(this.productService.updateProduct(productDTO));
    }


    @PostMapping(value = {"/", ""}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(this.productService.create(productDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        Optional<ProductDTO> product = this.productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Page<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(this.productService.getAllProducts(0, 10));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        this.productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<ProductDTO> getProductByName(@PathVariable("name") String name) {
        Optional<ProductDTO> productDTO = this.productService.getProductByName(name);
        return productDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/description/{desc}")
    public ResponseEntity<List<ProductDTO>> getProductByDescription(@PathVariable("desc") String desc) {
        return ResponseEntity.ok(this.productService.getProductByDescription(desc));
    }
}
