package com.example.category.application.usecases;

import com.example.category.domain.model.Category;
import com.example.category.domain.port.in.GetCategoryUseCase;
import com.example.category.domain.port.out.CategoryRepositoryPort;
import java.util.List;
import java.util.Optional;

public class GetCategoryUseCaseImplementation implements GetCategoryUseCase {

  private final CategoryRepositoryPort categoryRepositoryPort;

  public GetCategoryUseCaseImplementation(CategoryRepositoryPort categoryRepositoryPort) {
    this.categoryRepositoryPort = categoryRepositoryPort;
  }

  @Override
  public Optional<Category> getCategory(String categoryId) {
    return categoryRepositoryPort.findByNit(categoryId);
  }

  @Override
  public List<Category> getCategories() {
    return categoryRepositoryPort.findAll();
  }
}
