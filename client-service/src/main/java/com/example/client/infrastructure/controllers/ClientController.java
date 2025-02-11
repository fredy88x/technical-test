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
  public ResponseEntity<?> createClient(@RequestBody Client client) {
    return new ResponseEntity<>(createClientUseCase.createClient(client), HttpStatus.CREATED);
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<?> getClientById(@PathVariable String clientId) {
    return getClientUseCase.getClient(clientId)
        .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getAllClients() {
    return new ResponseEntity<>(getClientUseCase.getClients(), HttpStatus.OK);
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<?> updateClient(@PathVariable String clientId,
      @RequestBody Client client) {
    return updateClientUseCase.updateClient(clientId, client)
        .map(clientElement -> new ResponseEntity<>(clientElement, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
