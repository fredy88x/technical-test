package com.example.category.infrastructure.controllers;


import com.example.category.domain.model.Category;
import com.example.category.domain.port.in.CreateCategoryUseCase;
import com.example.category.domain.port.in.GetCategoryUseCase;
import com.example.category.domain.port.in.UpdateCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

  private final CreateCategoryUseCase createCategoryUseCase;
  private final GetCategoryUseCase getCategoryUseCase;
  private final UpdateCategoryUseCase updateCategoryUseCase;

  @PostMapping
  public ResponseEntity<?> createCategory(@RequestBody Category category) {
    return new ResponseEntity<>(createCategoryUseCase.createCategory(category), HttpStatus.CREATED);
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<?> getCategoryById(@PathVariable String categoryId) {
    return getCategoryUseCase.getCategory(categoryId)
        .map(Category -> new ResponseEntity<>(Category, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getAllCompanies() {
    return new ResponseEntity<>(getCategoryUseCase.getCategories(), HttpStatus.OK);
  }

  @PutMapping("/{categoryId}")
  public ResponseEntity<?> updateCategory(@PathVariable String categoryId,
      @RequestBody Category category) {
    return updateCategoryUseCase.updateCategory(categoryId, category)
        .map(CategoryElement -> new ResponseEntity<>(CategoryElement, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
