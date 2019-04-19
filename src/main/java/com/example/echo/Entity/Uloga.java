package com.example.echo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Uloga {
    private int idUloga;
    private String naziv;
    private List<Korisnik> korisnici;

    @Id
    @Column(name = "idUloga")
    public int getIdUloga() {
        return idUloga;
    }

    public void setIdUloga(int idUloga) {
        this.idUloga = idUloga;
    }

    @Basic
    @Column(name = "naziv")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "uloga")
    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
