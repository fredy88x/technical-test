package com.example.product.infrastructure.config;

import com.example.product.application.usecases.CreateProductUseCaseImplementation;
import com.example.product.application.usecases.GetProductUseCaseImplementation;
import com.example.product.application.usecases.UpdateProductUseCaseImplementation;
import com.example.product.domain.port.in.CreateProductUseCase;
import com.example.product.domain.port.in.GetProductUseCase;
import com.example.product.domain.port.in.UpdateProductUseCase;
import com.example.product.domain.port.out.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

  @Bean
  public CreateProductUseCase createProductUseCase(ProductRepositoryPort productRepositoryPort) {
    return new CreateProductUseCaseImplementation(productRepositoryPort);
  }

  @Bean
  public UpdateProductUseCase updateProductUseCase(ProductRepositoryPort productRepositoryPort) {
    return new UpdateProductUseCaseImplementation(productRepositoryPort);
  }

  @Bean
  public GetProductUseCase getProductUseCase(ProductRepositoryPort productRepositoryPort) {
    return new GetProductUseCaseImplementation(productRepositoryPort);
  }
}
