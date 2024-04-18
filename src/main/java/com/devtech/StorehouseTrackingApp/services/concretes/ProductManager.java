package com.devtech.StorehouseTrackingApp.services.concretes;

import com.devtech.StorehouseTrackingApp.entities.Product;
import com.devtech.StorehouseTrackingApp.entities.Storehouse;
import com.devtech.StorehouseTrackingApp.exceptions.ProductNotFoundException;
import com.devtech.StorehouseTrackingApp.exceptions.StorehouseNotFoundException;
import com.devtech.StorehouseTrackingApp.repositories.ProductRepository;
import com.devtech.StorehouseTrackingApp.requests.ProductCreateRequest;
import com.devtech.StorehouseTrackingApp.requests.ProductUpdateRequest;
import com.devtech.StorehouseTrackingApp.responses.ProductResponse;
import com.devtech.StorehouseTrackingApp.services.abstracts.ProductService;
import com.devtech.StorehouseTrackingApp.services.abstracts.StorehouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private StorehouseService storehouseService;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductResponse> getProductsByStorehouseId(Long id) {
        List<Product> list = productRepository.findByStorehouseId(id);
        Storehouse foundStorehouse = storehouseService.getOneStorehouseById(id);
        if(foundStorehouse != null) {
            return list.stream().map(l -> new ProductResponse(l)).collect(Collectors.toList());
        } else
            throw new StorehouseNotFoundException("The storehouse with id: '" + id + "' not found");
    }

    @Override
    public Product getOneProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
        //return new ProductResponse(product);
    }

    @Override
    public Product createOneProduct(ProductCreateRequest request) {
        Storehouse storehouse = storehouseService.getOneStorehouseById(request.getStorehouseId());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        if(storehouse != null) {
            Product productToSave = new Product();
            productToSave.setEntryPrice(request.getEntryPrice());
            productToSave.setQuantity(request.getQuantity());
            productToSave.setProductName(request.getProductName());
            productToSave.setEntryDate(formatter.format(date));
            productToSave.setStorehouse(storehouse);
            return productRepository.save(productToSave);
        } else
            return null;
    }

    @Override
    public Product updateOneProduct(Long productId, ProductUpdateRequest request) {
        Optional<Product> productToUpdate = productRepository.findById(productId);
        Storehouse storehouse = storehouseService.getOneStorehouseById(request.getStorehouseId());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        if(productToUpdate.isPresent()) {
            Product foundProduct = productToUpdate.get();
            foundProduct.setEntryPrice(request.getEntryPrice());
            foundProduct.setQuantity(request.getQuantity());
            foundProduct.setProductName(request.getProductName());
            foundProduct.setEntryDate(formatter.format(date));
            foundProduct.setStorehouse(storehouse);
            return productRepository.save(foundProduct);
        } else
            throw new ProductNotFoundException("The product with id: '" + productId + "' not found");

    }

    @Override
    public void deleteOneProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
