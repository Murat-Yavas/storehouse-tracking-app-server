package com.devtech.StorehouseTrackingApp.services.abstracts;

import com.devtech.StorehouseTrackingApp.entities.Product;
import com.devtech.StorehouseTrackingApp.requests.ProductCreateRequest;
import com.devtech.StorehouseTrackingApp.requests.ProductUpdateRequest;
import com.devtech.StorehouseTrackingApp.responses.ProductResponse;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<ProductResponse> getProductsByStorehouseId(Long id);
    Product getOneProductById(Long productId);
    Product createOneProduct(ProductCreateRequest newProduct);
    Product updateOneProduct(Long productId, ProductUpdateRequest product);
    void deleteOneProduct(Long productId);
}
