package com.market.backend.market.model;

import jakarta.persistence.*;

@Entity
@Table(name = "egzemplarze")
public class Egzemplarze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "produkt_id", nullable = false, unique = true)
    private Produkt produkt;

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