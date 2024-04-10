package com.market.backend.market.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zamowienia")
public class Zamowienia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "klienci_id", nullable = false, unique = true)
    private Klienci klienci;

    @ManyToOne(optional = false)
    @JoinColumn(name = "adres_id", nullable = false)
    private Adres adres;

    @OneToMany(mappedBy = "zamowienia", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ZamowieniaIlosc> zamowieniaIlosci = new ArrayList<>();

    public List<ZamowieniaIlosc> getZamowieniaIlosci() {
        return zamowieniaIlosci;
    }

    public void setZamowieniaIlosci(List<ZamowieniaIlosc> zamowieniaIlosci) {
        this.zamowieniaIlosci = zamowieniaIlosci;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Klienci getKlienci() {
        return klienci;
    }

    public void setKlienci(Klienci klienci) {
        this.klienci = klienci;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}