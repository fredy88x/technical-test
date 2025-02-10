package com.example.order.infrastructure.repositories;


import com.example.order.domain.model.Order;
import com.example.order.domain.port.out.OrderRepositoryPort;
import com.example.order.infrastructure.entities.OrderEntity;
import com.example.order.infrastructure.mapper.OrderMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryAdapter implements OrderRepositoryPort {

  private final JpaOrderRepository jpaOrderRepository;

  public OrderRepositoryAdapter(JpaOrderRepository jpaOrderRepository) {
    this.jpaOrderRepository = jpaOrderRepository;
  }


  @Override
  public Order save(Order order) {
    OrderEntity orderEntity = OrderMapper.INSTANCE.orderToOrderEntity(order);
    OrderEntity orderSaved = jpaOrderRepository.save(orderEntity);
    return OrderMapper.INSTANCE.orderEntityToOrder(orderSaved);
  }

  @Override
  public Optional<Order> findByNit(String nit) {
    return jpaOrderRepository.findById(nit).map(OrderMapper.INSTANCE::orderEntityToOrder);
  }

  @Override
  public List<Order> findAll() {
    return jpaOrderRepository.findAll().stream()
        .map(OrderMapper.INSTANCE::orderEntityToOrder).toList();
  }

  @Override
  public Optional<Order> update(Order Order) {
    return Optional.ofNullable(Order)
        .filter(element -> jpaOrderRepository.existsById(Order.getId()))
        .map(OrderMapper.INSTANCE::orderToOrderEntity)
        .map(jpaOrderRepository::save)
        .map(OrderMapper.INSTANCE::orderEntityToOrder);
  }
}
