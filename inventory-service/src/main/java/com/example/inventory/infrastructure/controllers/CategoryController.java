package com.example.inventory.infrastructure.controllers;


import com.example.inventory.domain.model.Inventory;
import com.example.inventory.domain.port.in.CreateInventoryUseCase;
import com.example.inventory.domain.port.in.GetInventoryUseCase;
import com.example.inventory.domain.port.in.UpdateInventoryUseCase;
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

  private final CreateInventoryUseCase createInventoryUseCase;
  private final GetInventoryUseCase getInventoryUseCase;
  private final UpdateInventoryUseCase updateInventoryUseCase;

  @PostMapping
  public ResponseEntity<?> createCategory(@RequestBody Inventory inventory) {
    return new ResponseEntity<>(createInventoryUseCase.createInventory(inventory), HttpStatus.CREATED);
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<?> getCategoryById(@PathVariable String categoryId) {
    return getInventoryUseCase.getInventory(categoryId)
        .map(Category -> new ResponseEntity<>(Category, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getAllCompanies() {
    return new ResponseEntity<>(getInventoryUseCase.getInventories(), HttpStatus.OK);
  }

  @PutMapping("/{categoryId}")
  public ResponseEntity<?> updateCategory(@PathVariable String categoryId,
      @RequestBody Inventory inventory) {
    return updateInventoryUseCase.updateInventory(categoryId, inventory)
        .map(CategoryElement -> new ResponseEntity<>(CategoryElement, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
