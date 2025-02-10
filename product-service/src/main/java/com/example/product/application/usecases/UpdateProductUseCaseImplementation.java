package com.example.product.application.usecases;

import com.example.product.domain.model.Product;
import com.example.product.domain.port.in.UpdateProductUseCase;
import com.example.product.domain.port.out.ProductRepositoryPort;
import java.util.Optional;

public class UpdateProductUseCaseImplementation implements UpdateProductUseCase {

  private final ProductRepositoryPort productRepositoryPort;

  public UpdateProductUseCaseImplementation(ProductRepositoryPort productRepositoryPort) {
    this.productRepositoryPort = productRepositoryPort;
  }

  @Override
  public Optional<Product> updateProduct(String id, Product updatedProduct) {
    return productRepositoryPort.update(updatedProduct);
  }
}
