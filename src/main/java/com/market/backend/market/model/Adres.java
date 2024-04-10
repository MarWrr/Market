package com.market.backend.market.model;

import jakarta.persistence.*;

@Entity
@Table(name = "adres")
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "miasto", nullable = false)
    private String miasto;

    @Column(name = "wojewdztwo", nullable = false)
    private String wojewdztwo;

    @Column(name = "kod_pocztowy", nullable = false, length = 10)
    private String kod_pocztowy;

    @Column(name = "ulica", nullable = false)
    private String ulica;

    @Column(name = "nr_domu", nullable = false)
    private Integer nr_domu;

    @Column(name = "nr_lokalu", nullable = false)
    private Integer nr_lokalu;

    @ManyToOne(optional = false)
    @JoinColumn(name = "klient_id", nullable = false)
    private Klienci klient;

    public Klienci getKlient() {
        return klient;
    }

    public void setKlient(Klienci klient) {
        this.klient = klient;
    }

    public Integer getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(Integer nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    public Integer getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(Integer nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getWojewdztwo() {
        return wojewdztwo;
    }

    public void setWojewdztwo(String wojewdztwo) {
        this.wojewdztwo = wojewdztwo;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}