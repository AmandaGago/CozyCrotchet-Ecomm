package com.cozycreations.backend.controllers;

import com.cozycreations.backend.Repository.ProductRepository;
import com.cozycreations.backend.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //returns JSON response
@RequestMapping("api/products")
@CrossOrigin(origins = "*") // allows angular front end to call the backend later
public class productController {
    private final ProductRepository productRepository;

    public productController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    
    @GetMapping('/{id}')
    public Product getProductById(@PathVariable Long Id){
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeExcpetion ("Product Not Found");
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping(value = "/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct){
        Product product=productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not Found"));

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setImageUrl(updatedProduct.getImageUrl());
        product.setCategory(updatedProduct.getCategory());
        product.setStockQuantity(updatedProduct.getStockQuantity());

        return productRepository.save(product);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}
