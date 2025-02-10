package com.example.client.infrastructure.mapper;

import com.example.client.domain.model.Client;
import com.example.client.infrastructure.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  ClientEntity clientToClientEntity(Client client);

  Client clientEntityToClient(ClientEntity clientEntity);
}
