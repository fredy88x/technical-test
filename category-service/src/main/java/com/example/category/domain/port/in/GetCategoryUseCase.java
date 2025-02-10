package com.example.category.domain.port.in;

import com.example.category.domain.model.Category;
import java.util.List;
import java.util.Optional;

public interface GetCategoryUseCase {

  Optional<Category> getCategory(String categoryId);

  List<Category> getCategories();
}
