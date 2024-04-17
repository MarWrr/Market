package com.market.backend.market.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Users users;

    @OneToMany(mappedBy = "quantity_available", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Quantity> quantityOrder = new ArrayList<>();

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "is_order_completed", nullable = false)
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean isOrderCompleted = false;

    public Boolean getIsOrderCompleted() {
        return isOrderCompleted;
    }

    public void setIsOrderCompleted(Boolean isOrderCompleted) {
        this.isOrderCompleted = isOrderCompleted;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Quantity> getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(List<Quantity> quantityOrder) {
        this.quantityOrder = quantityOrder;
    }



    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}