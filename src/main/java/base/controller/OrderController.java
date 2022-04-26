package base.controller;

import base.repository.OrderRepository;
import base.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("getOrders")
    public ResponseEntity<?> listOrder(){
          return ResponseEntity.ok(orderRepository.findAll());
    }
}
