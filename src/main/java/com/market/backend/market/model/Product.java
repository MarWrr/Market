package com.market.backend.market.model;

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
    private String product_name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "photo", unique = true, length = 45)
    private String photo;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Quantity quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PhotoGallery> photogalleries = new ArrayList<>();

    public List<PhotoGallery> getGaleriaZdjecs() {
        return photogalleries;
    }

    public void setGaleriaZdjecs(List<PhotoGallery> photogalleries) {
        this.photogalleries = photogalleries;
    }

    public Quantity getEgzemplarze() {
        return quantity;
    }

    public void setEgzemplarze(Quantity quantity) {
        this.quantity = quantity;
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
        return product_name;
    }

    public void setProduct_name(String nazwa) {
        this.product_name = nazwa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}