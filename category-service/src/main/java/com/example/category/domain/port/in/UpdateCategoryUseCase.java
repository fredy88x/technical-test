package com.example.category.domain.port.in;

import com.example.category.domain.model.Category;
import java.util.Optional;

public interface UpdateCategoryUseCase {

  Optional<Category> updateCategory(String id, Category updatedCategory);
}
