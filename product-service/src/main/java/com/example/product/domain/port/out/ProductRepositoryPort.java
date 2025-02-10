package com.example.product.domain.port.out;

import com.example.product.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

  Product save(Product product);

  Optional<Product> findByNit(String nit);

  List<Product> findAll();

  Optional<Product> update(Product product);
}
