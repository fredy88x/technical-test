package com.example.product.application.usecases;

import com.example.product.domain.model.Product;
import com.example.product.domain.port.in.GetProductUseCase;
import com.example.product.domain.port.out.ProductRepositoryPort;
import java.util.List;
import java.util.Optional;

public class GetProductUseCaseImplementation implements GetProductUseCase {

  private final ProductRepositoryPort productRepositoryPort;

  public GetProductUseCaseImplementation(ProductRepositoryPort productRepositoryPort) {
    this.productRepositoryPort = productRepositoryPort;
  }

  @Override
  public Optional<Product> getProduct(String productId) {
    return productRepositoryPort.findByNit(productId);
  }

  @Override
  public List<Product> getProducts() {
    return productRepositoryPort.findAll();
  }
}
