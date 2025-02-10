package com.example.category.domain.port.in;


import com.example.category.domain.model.Category;

public interface CreateCategoryUseCase {

  Category createCategory(Category category);
}
