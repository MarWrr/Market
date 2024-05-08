package com.market.backend.market.service;

import com.market.backend.market.model.Orders;
import com.market.backend.market.model.Users;
import com.market.backend.market.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<Orders> getOrders(Users user){
        return webOrderDAO.findByUsers(user);
    }
}
