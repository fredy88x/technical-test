package com.example.category.infrastructure.repositories;


import com.example.category.domain.model.Category;
import com.example.category.domain.port.out.CategoryRepositoryPort;
import com.example.category.infrastructure.entities.CategoryEntity;
import com.example.category.infrastructure.mapper.CategoryMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {

  private final JpaCategoryRepository jpaCategoryRepository;

  public CategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository) {
    this.jpaCategoryRepository = jpaCategoryRepository;
  }


  @Override
  public Category save(Category category) {
    CategoryEntity categoryEntity = CategoryMapper.INSTANCE.categoryToCategoryEntity(category);
    CategoryEntity categorySaved = jpaCategoryRepository.save(categoryEntity);
    return CategoryMapper.INSTANCE.categoryEntityToCategory(categorySaved);
  }

  @Override
  public Optional<Category> findByNit(String nit) {
    return jpaCategoryRepository.findById(nit)
        .map(CategoryMapper.INSTANCE::categoryEntityToCategory);
  }

  @Override
  public List<Category> findAll() {
    return jpaCategoryRepository.findAll().stream()
        .map(CategoryMapper.INSTANCE::categoryEntityToCategory).toList();
  }

  @Override
  public Optional<Category> update(Category Category) {
    return Optional.ofNullable(Category)
        .filter(element -> jpaCategoryRepository.existsById(Category.getNit()))
        .map(CategoryMapper.INSTANCE::categoryToCategoryEntity)
        .map(jpaCategoryRepository::save)
        .map(CategoryMapper.INSTANCE::categoryEntityToCategory);
  }
}
