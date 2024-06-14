package com.market.backend.market.model;

import jakarta.persistence.*;

@Entity
@Table(name = "photo_gallery")
public class PhotoGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id", unique = true)
    private Long product;

    @Column(name = "name_jpg", unique = true, length = 45)
    private String name_jpg;

    public String getName_jpg() {
        return name_jpg;
    }

    public void setName_jpg(String name_jpg) {
        this.name_jpg = name_jpg;
    }

    public Long getProdukt() {
        return product;
    }

    public void setProdukt(Long product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}