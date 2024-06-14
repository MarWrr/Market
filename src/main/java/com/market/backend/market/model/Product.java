package com.market.backend.market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "photo", unique = true, length = 45)
    private String photo;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PhotoGallery> photogalleries;


    @JsonIgnore
    public List<PhotoGallery> getPhotogalleries() {
        return photogalleries;
    }


    public void setPhotogalleries(List<PhotoGallery> photogalleries) {
        this.photogalleries = photogalleries;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String fotografia) {
        this.photo = fotografia;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double cena) {
        this.price = cena;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String opis) {
        this.description = opis;
    }

    public String getProduct_name() {
        return productName;
    }

    public void setProduct_name(String nazwa) {
        this.productName = nazwa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}