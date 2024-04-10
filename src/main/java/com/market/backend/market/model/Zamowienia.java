package com.market.backend.market.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "zamowienia", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ZamowieniaIlosc> zamowieniaIlosci = new ArrayList<>();

    @Column(name = "kwota", nullable = false)
    private Double kwota;

    @Column(name = "data_zamowienia", nullable = false)
    private LocalDateTime dataZamowienia;

    @Column(name = "czy_zamowienie_zrealizowano", nullable = false)
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean czy_zamowienie_zrealizowano = false;

    public Boolean getCzy_zamowienie_zrealizowano() {
        return czy_zamowienie_zrealizowano;
    }

    public void setCzy_zamowienie_zrealizowano(Boolean czy_zamowienie_zrealizowano) {
        this.czy_zamowienie_zrealizowano = czy_zamowienie_zrealizowano;
    }

    public LocalDateTime getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(LocalDateTime dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public Double getKwota() {
        return kwota;
    }

    public void setKwota(Double kwota) {
        this.kwota = kwota;
    }

    public List<ZamowieniaIlosc> getZamowieniaIlosci() {
        return zamowieniaIlosci;
    }

    public void setZamowieniaIlosci(List<ZamowieniaIlosc> zamowieniaIlosci) {
        this.zamowieniaIlosci = zamowieniaIlosci;
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