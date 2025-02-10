package com.example.order.infrastructure.controllers;


import com.example.order.domain.model.Order;
import com.example.order.domain.port.in.CreateOrderUseCase;
import com.example.order.domain.port.in.GetOrderUseCase;
import com.example.order.domain.port.in.UpdateOrderUseCase;
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
@RequestMapping("/api/Order")
public class OrderController {

  private final CreateOrderUseCase createOrderUseCase;
  private final GetOrderUseCase getOrderUseCase;
  private final UpdateOrderUseCase updateOrderUseCase;

  public OrderController(CreateOrderUseCase createOrderUseCase,
      GetOrderUseCase getOrderUseCase, UpdateOrderUseCase updateOrderUseCase) {
    this.createOrderUseCase = createOrderUseCase;
    this.getOrderUseCase = getOrderUseCase;
    this.updateOrderUseCase = updateOrderUseCase;
  }

  @PostMapping
  public ResponseEntity<?> createOrder(@RequestBody Order Order) {
    return new ResponseEntity<>(createOrderUseCase.createOrder(Order), HttpStatus.CREATED);
  }

  @GetMapping("/{OrderId}")
  public ResponseEntity<?> getOrderById(@PathVariable String OrderId) {
    return getOrderUseCase.getOrder(OrderId)
        .map(Order -> new ResponseEntity<>(Order, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping
  public ResponseEntity<?> getAllCompanies() {
    return new ResponseEntity<>(getOrderUseCase.getOrders(), HttpStatus.OK);
  }

  @PutMapping("/{OrderId}")
  public ResponseEntity<?> updateOrder(@PathVariable String OrderId,
      @RequestBody Order Order) {
    return updateOrderUseCase.updateOrder(OrderId, Order)
        .map(OrderElement -> new ResponseEntity<>(OrderElement, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
