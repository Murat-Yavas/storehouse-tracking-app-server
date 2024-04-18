package com.devtech.StorehouseTrackingApp.controllers;

import com.devtech.StorehouseTrackingApp.entities.Product;
import com.devtech.StorehouseTrackingApp.requests.ProductCreateRequest;
import com.devtech.StorehouseTrackingApp.requests.ProductUpdateRequest;
import com.devtech.StorehouseTrackingApp.responses.ProductResponse;
import com.devtech.StorehouseTrackingApp.services.abstracts.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> receiveAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createOneProduct(@RequestBody ProductCreateRequest newProduct) {
        return productService.createOneProduct(newProduct);
    }

    @GetMapping("/storehouse/{storehouseId}")
    public List<ProductResponse> receiveProductsByStorehouseId(@PathVariable Long storehouseId) {
        return productService.getProductsByStorehouseId(storehouseId);
    }

    @GetMapping("/{productId}")
    public Product receiveOneProduct(@PathVariable Long productId) {
        return productService.getOneProductById(productId);
    }

    @PutMapping("/{productId}")
    public Product updateOneProduct(@PathVariable Long productId, @RequestBody ProductUpdateRequest product) {
        return productService.updateOneProduct(productId,product);
    }

    @DeleteMapping("/{productId}")
    public void deleteOneProduct(@PathVariable Long productId) {
        productService.deleteOneProduct(productId);
    }
}
