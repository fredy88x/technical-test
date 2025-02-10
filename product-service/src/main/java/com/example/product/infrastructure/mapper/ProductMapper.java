package com.example.product.infrastructure.mapper;

import com.example.product.domain.model.Product;
import com.example.product.infrastructure.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  ProductEntity productToProductEntity(Product product);

  Product productEntityToProduct(ProductEntity productEntity);
}
