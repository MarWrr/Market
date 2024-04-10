package com.market.backend.market.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produkt")
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nazwa", nullable = false, unique = true)
    private String nazwa;

    @Column(name = "opis", nullable = false, columnDefinition = "TEXT")
    private String opis;

    @Column(name = "cena", nullable = false)
    private Double cena;

    @Column(name = "fotografia", unique = true, length = 45)
    private String fotografia;

    @OneToOne(mappedBy = "produkt", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Egzemplarze egzemplarze;

    @OneToMany(mappedBy = "produkt", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<GaleriaZdjec> galeriaZdjecs = new ArrayList<>();

    public List<GaleriaZdjec> getGaleriaZdjecs() {
        return galeriaZdjecs;
    }

    public void setGaleriaZdjecs(List<GaleriaZdjec> galeriaZdjecs) {
        this.galeriaZdjecs = galeriaZdjecs;
    }

    public Egzemplarze getEgzemplarze() {
        return egzemplarze;
    }

    public void setEgzemplarze(Egzemplarze egzemplarze) {
        this.egzemplarze = egzemplarze;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}