package com.example.product.domain.port.in;

import com.example.product.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface GetProductUseCase {

  Optional<Product> getProduct(String productId);

  List<Product> getProducts();
}
