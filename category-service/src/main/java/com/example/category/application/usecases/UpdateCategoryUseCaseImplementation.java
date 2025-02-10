package com.example.category.application.usecases;


import com.example.category.domain.model.Category;
import com.example.category.domain.port.in.UpdateCategoryUseCase;
import com.example.category.domain.port.out.CategoryRepositoryPort;
import java.util.Optional;

public class UpdateCategoryUseCaseImplementation implements UpdateCategoryUseCase {

  private final CategoryRepositoryPort categoryRepositoryPort;

  public UpdateCategoryUseCaseImplementation(CategoryRepositoryPort categoryRepositoryPort) {
    this.categoryRepositoryPort = categoryRepositoryPort;
  }

  @Override
  public Optional<Category> updateCategory(String id, Category updatedCategory) {
    return categoryRepositoryPort.update(updatedCategory);
  }
}
