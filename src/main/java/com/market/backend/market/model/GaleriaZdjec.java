package com.market.backend.market.model;

import jakarta.persistence.*;

@Entity
@Table(name = "galeria_zdjec")
public class GaleriaZdjec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "produkt_id", unique = true)
    private Produkt produkt;

    @Column(name = "nazwa_jpg", unique = true, length = 45)
    private String nazwa_jpg;

    public String getNazwa_jpg() {
        return nazwa_jpg;
    }

    public void setNazwa_jpg(String nazwa_jpg) {
        this.nazwa_jpg = nazwa_jpg;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}