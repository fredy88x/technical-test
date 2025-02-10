package com.example.order.infrastructure.mapper;


import com.example.order.domain.model.Order;
import com.example.order.infrastructure.entities.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  OrderEntity orderToOrderEntity(Order order);

  Order orderEntityToOrder(OrderEntity orderEntity);
}
