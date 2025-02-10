package com.example.client.infrastructure.repositories;


import com.example.client.domain.model.Client;
import com.example.client.domain.port.out.ClientRepositoryPort;
import com.example.client.infrastructure.entities.ClientEntity;
import com.example.client.infrastructure.mapper.ClientMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class ClientRepositoryAdapter implements ClientRepositoryPort {

  private final JpaProductRepository jpaClientRepository;

  public ClientRepositoryAdapter(JpaProductRepository jpaClientRepository) {
    this.jpaClientRepository = jpaClientRepository;
  }


  @Override
  public Client save(Client client) {
    ClientEntity clientEntity = ClientMapper.INSTANCE.clientToClientEntity(client);
    ClientEntity ProductSaved = jpaClientRepository.save(clientEntity);
    return ClientMapper.INSTANCE.clientEntityToClient(ProductSaved);
  }

  @Override
  public Optional<Client> findByNit(String nit) {
    return jpaClientRepository.findById(nit).map(ClientMapper.INSTANCE::clientEntityToClient);
  }

  @Override
  public List<Client> findAll() {
    return jpaClientRepository.findAll().stream()
        .map(ClientMapper.INSTANCE::clientEntityToClient).toList();
  }

  @Override
  public Optional<Client> update(
      Client client) {
    return Optional.ofNullable(client)
        .filter(element -> jpaClientRepository.existsById(client.getNit()))
        .map(ClientMapper.INSTANCE::clientToClientEntity)
        .map(jpaClientRepository::save)
        .map(ClientMapper.INSTANCE::clientEntityToClient);
  }
}
