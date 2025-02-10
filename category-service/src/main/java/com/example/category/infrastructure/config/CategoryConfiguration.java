package com.example.category.infrastructure.config;


import com.example.category.application.usecases.CreateCategoryUseCaseImplementation;
import com.example.category.application.usecases.GetCategoryUseCaseImplementation;
import com.example.category.application.usecases.UpdateCategoryUseCaseImplementation;
import com.example.category.domain.port.in.CreateCategoryUseCase;
import com.example.category.domain.port.in.GetCategoryUseCase;
import com.example.category.domain.port.in.UpdateCategoryUseCase;
import com.example.category.domain.port.out.CategoryRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfiguration {

  @Bean
  public CreateCategoryUseCase createCategoryUseCase(
      CategoryRepositoryPort categoryRepositoryPort) {
    return new CreateCategoryUseCaseImplementation(categoryRepositoryPort);
  }

  @Bean
  public UpdateCategoryUseCase updateCategoryUseCase(
      CategoryRepositoryPort categoryRepositoryPort) {
    return new UpdateCategoryUseCaseImplementation(categoryRepositoryPort);
  }

  @Bean
  public GetCategoryUseCase getCategoryUseCase(CategoryRepositoryPort categoryRepositoryPort) {
    return new GetCategoryUseCaseImplementation(categoryRepositoryPort);
  }
}
