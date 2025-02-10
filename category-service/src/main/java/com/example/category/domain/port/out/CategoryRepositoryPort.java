package com.example.category.domain.port.out;

import com.example.category.domain.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {

  Category save(Category category);

  Optional<Category> findByNit(String nit);

  List<Category> findAll();

  Optional<Category> update(Category category);
}
