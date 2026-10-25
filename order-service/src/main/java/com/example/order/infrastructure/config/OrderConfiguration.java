package com.example.order.infrastructure.config;


import com.example.order.application.usecases.CreateOrderUseCaseImplementation;
import com.example.order.application.usecases.GetOrderUseCaseImplementation;
import com.example.order.application.usecases.UpdateOrderUseCaseImplementation;
import com.example.order.domain.port.in.CreateOrderUseCase;
import com.example.order.domain.port.in.GetOrderUseCase;
import com.example.order.domain.port.in.UpdateOrderUseCase;
import com.example.order.domain.port.out.ClientRestPort;
import com.example.order.domain.port.out.OrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public CreateOrderUseCase createOrderUseCase(OrderRepositoryPort OrderRepositoryPort, ClientRestPort clientRestPort) {
    return new CreateOrderUseCaseImplementation(OrderRepositoryPort, clientRestPort);
  }

  @Bean
  public UpdateOrderUseCase updateOrderUseCase(OrderRepositoryPort OrderRepositoryPort) {
    return new UpdateOrderUseCaseImplementation(OrderRepositoryPort);
  }

  @Bean
  public GetOrderUseCase getOrderUseCase(OrderRepositoryPort OrderRepositoryPort) {
    return new GetOrderUseCaseImplementation(OrderRepositoryPort);
  }
}
