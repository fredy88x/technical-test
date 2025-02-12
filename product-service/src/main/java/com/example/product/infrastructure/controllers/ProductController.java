package com.example.product.infrastructure.controllers;


import com.example.product.domain.model.Product;
import com.example.product.domain.port.in.CreateProductUseCase;
import com.example.product.domain.port.in.GetProductUseCase;
import com.example.product.domain.port.in.UpdateProductUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/api/product")
public class ProductController {

  private final CreateProductUseCase createProductUseCase;
  private final GetProductUseCase getProductUseCase;
  private final UpdateProductUseCase updateProductUseCase;

  public ProductController(CreateProductUseCase createproductUseCase,
      GetProductUseCase getproductUseCase, UpdateProductUseCase updateproductUseCase) {
    this.createProductUseCase = createproductUseCase;
    this.getProductUseCase = getproductUseCase;
    this.updateProductUseCase = updateproductUseCase;
  }

  @PostMapping
  public ResponseEntity<?> createProduct(@RequestBody Product product) {
    return new ResponseEntity<>(createProductUseCase.createProduct(product), HttpStatus.CREATED);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<?> getProductById(@PathVariable String productId) {
    return getProductUseCase.getProduct(productId)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getAllCompanies() {
    return new ResponseEntity<>(getProductUseCase.getProducts(), HttpStatus.OK);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<?> updateProduct(@PathVariable String productId,
      @RequestBody Product product) {
    return updateProductUseCase.updateProduct(productId, product)
        .map(productElement -> new ResponseEntity<>(productElement, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
