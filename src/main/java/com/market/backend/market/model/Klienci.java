package com.market.backend.market.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "klienci")
public class Klienci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "haslo", nullable = false, length = 1000)
    private String haslo;

    @Column(name = "email", nullable = false, unique = true, length = 320)
    private String email;

    @Column(name = "imie", nullable = false, length = 100)
    private String imie;

    @Column(name = "nazwisko", nullable = false, length = 200)
    private String nazwisko;

    @OneToMany(mappedBy = "klient", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Adres> adresy = new ArrayList<>();

    public List<Adres> getAdresy() {
        return adresy;
    }

    public void setAdresy(List<Adres> adresy) {
        this.adresy = adresy;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}