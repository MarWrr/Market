package com.market.backend.market.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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

    @Column(name = "dostepna_ilosc", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer dostepna_ilosc;

    public Integer getDostepna_ilosc() {
        return dostepna_ilosc;
    }

    public void setDostepna_ilosc(Integer dostepna_ilosc) {
        this.dostepna_ilosc = dostepna_ilosc;
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

    public void voidsetId(Long id) {
        this.id = id;
    }

}