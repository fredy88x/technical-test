package com.example.product.infrastructure.repositories;


import com.example.product.domain.model.Product;
import com.example.product.domain.port.out.ProductRepositoryPort;
import com.example.product.infrastructure.entities.ProductEntity;
import com.example.product.infrastructure.mapper.ProductMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

  private final JpaProductRepository jpaProductRepository;

  public ProductRepositoryAdapter(JpaProductRepository jpaProductRepository) {
    this.jpaProductRepository = jpaProductRepository;
  }


  @Override
  public Product save(Product product) {
    ProductEntity productEntity = ProductMapper.INSTANCE.productToProductEntity(product);
    ProductEntity ProductSaved = jpaProductRepository.save(productEntity);
    return ProductMapper.INSTANCE.productEntityToProduct(ProductSaved);
  }

  @Override
  public Optional<Product> findByNit(String nit) {
    return jpaProductRepository.findById(nit).map(ProductMapper.INSTANCE::productEntityToProduct);
  }

  @Override
  public List<Product> findAll() {
    return jpaProductRepository.findAll().stream()
        .map(ProductMapper.INSTANCE::productEntityToProduct).toList();
  }

  @Override
  public Optional<Product> update(Product product) {
    return Optional.ofNullable(product)
        .filter(element -> jpaProductRepository.existsById(product.getCode()))
        .map(ProductMapper.INSTANCE::productToProductEntity)
        .map(jpaProductRepository::save)
        .map(ProductMapper.INSTANCE::productEntityToProduct);
  }
}
