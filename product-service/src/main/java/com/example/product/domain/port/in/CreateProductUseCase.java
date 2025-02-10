package com.example.product.domain.port.in;

import com.example.product.domain.model.Product;

public interface CreateProductUseCase {

  Product createProduct(Product product);
}
