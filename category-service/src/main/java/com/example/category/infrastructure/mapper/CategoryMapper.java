package com.example.category.infrastructure.mapper;

import com.example.category.domain.model.Category;
import com.example.category.infrastructure.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  CategoryEntity categoryToCategoryEntity(Category category);

  Category categoryEntityToCategory(CategoryEntity categoryEntity);
}
