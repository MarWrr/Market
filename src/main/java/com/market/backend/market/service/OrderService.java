package com.market.backend.market.service;

import com.market.backend.market.model.OrderProduct;
import com.market.backend.market.model.Orders;
import com.market.backend.market.model.Users;
import com.market.backend.market.model.Product;
import com.market.backend.market.model.dao.ProductDAO;
import com.market.backend.market.model.dao.WebOrderDAO;
import jakarta.transaction.Transactional;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private WebOrderDAO webOrderDAO;
    private ProductDAO productDAO;

    public OrderService(WebOrderDAO webOrderDAO, ProductDAO productDAO) {
        this.webOrderDAO = webOrderDAO;
        this.productDAO = productDAO;
    }

    @Transactional
    public Orders makeOrder(Long productId, Integer quantity, @AuthenticationPrincipal Users user) {
        System.out.println("Received productId: " + productId);
        System.out.println("Finding product with ID: " + productId);
        Optional<Product> productOptional = productDAO.findById(productId);
        System.out.println("Product found: " + productOptional);

        Product product = productDAO.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        Orders order = new Orders();
        order.setUsers(user);
        order.setOrderDate(LocalDateTime.now());
        order.setIsOrderCompleted(false);

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(product);
        orderProduct.setOrders(order);
        orderProduct.setQuantity(quantity);

        double totalPrice = product.getPrice() * quantity;
        order.setPrice(totalPrice);

        order.getQuantityOrder().add(orderProduct);

        return webOrderDAO.save(order);
    }

    public List<Orders> getOrders(Users user){
        return webOrderDAO.findByUsers(user);
    }
}
