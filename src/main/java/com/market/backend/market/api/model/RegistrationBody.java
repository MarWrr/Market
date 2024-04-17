package com.market.backend.market.api.model;

import jakarta.validation.constraints.*;

public class RegistrationBody {

    @NotNull
    @NotBlank
    @Size(min=5, max=100)
    private String login;
    @NotNull
    @NotBlank
    //Minimum eight characters, at least one letter and one number:
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    @Size(min=6, max=32)
    private String haslo;
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String imie;
    @NotBlank
    @NotNull
    private String nazwisko;

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getEmail() {
        return email;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }


}
