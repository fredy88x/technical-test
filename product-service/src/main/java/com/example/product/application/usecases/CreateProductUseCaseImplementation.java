package com.example.product.application.usecases;

import com.example.product.domain.model.Product;
import com.example.product.domain.port.in.CreateProductUseCase;
import com.example.product.domain.port.out.ProductRepositoryPort;

public class CreateProductUseCaseImplementation implements CreateProductUseCase {

  private final ProductRepositoryPort productRepositoryPort;

  public CreateProductUseCaseImplementation(ProductRepositoryPort productRepositoryPort) {
    this.productRepositoryPort = productRepositoryPort;
  }

  @Override
  public Product createProduct(Product product) {
    return productRepositoryPort.save(product);
  }
}
