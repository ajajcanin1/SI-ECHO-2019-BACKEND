package com.example.echo.Entity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Uloga uloga = (Uloga) o;

        if (idUloga != uloga.idUloga) return false;
        if (naziv != null ? !naziv.equals(uloga.naziv) : uloga.naziv != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUloga;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "uloga")
    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
}
