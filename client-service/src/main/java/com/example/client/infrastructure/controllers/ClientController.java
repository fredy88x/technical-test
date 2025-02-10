package com.example.client.infrastructure.controllers;


import com.example.client.domain.model.Client;
import com.example.client.domain.port.in.CreateClientUseCase;
import com.example.client.domain.port.in.GetClientUseCase;
import com.example.client.domain.port.in.UpdateClientUseCase;
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
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

  private final CreateClientUseCase createClientUseCase;
  private final GetClientUseCase getClientUseCase;
  private final UpdateClientUseCase updateClientUseCase;

  @PostMapping
  public ResponseEntity<?> createProduct(@RequestBody Client client) {
    return new ResponseEntity<>(createClientUseCase.createClient(client), HttpStatus.CREATED);
  }

  @GetMapping("/{productId}")
  public ResponseEntity<?> getProductById(@PathVariable String productId) {
    return getClientUseCase.getClient(productId)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getAllCompanies() {
    return new ResponseEntity<>(getClientUseCase.getClients(), HttpStatus.OK);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<?> updateProduct(@PathVariable String productId,
      @RequestBody Client client) {
    return updateClientUseCase.updateClient(productId, client)
        .map(productElement -> new ResponseEntity<>(productElement, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
