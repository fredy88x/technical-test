package com.example.product.domain.port.in;

import com.example.product.domain.model.Product;
import java.util.Optional;

public interface UpdateProductUseCase {

  Optional<Product> updateProduct(String id, Product updatedProduct);
}
