package com.market.backend.market.api.controller.order;

import com.market.backend.market.model.Orders;
import com.market.backend.market.model.Users;
import com.market.backend.market.service.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getOrders(@AuthenticationPrincipal Users user) {
        return orderService.getOrders(user);
    }
}
