package com.example.category.application.usecases;


import com.example.category.domain.model.Category;
import com.example.category.domain.port.in.CreateCategoryUseCase;
import com.example.category.domain.port.out.CategoryRepositoryPort;

public class CreateCategoryUseCaseImplementation implements CreateCategoryUseCase {

  private final CategoryRepositoryPort categoryRepositoryPort;

  public CreateCategoryUseCaseImplementation(CategoryRepositoryPort categoryRepositoryPort) {
    this.categoryRepositoryPort = categoryRepositoryPort;
  }

  @Override
  public Category createCategory(Category category) {
    return categoryRepositoryPort.save(category);
  }
}
