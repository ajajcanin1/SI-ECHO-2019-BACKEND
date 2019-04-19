package com.example.echo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Predmet {
    private int id;
    private String naziv;
    private int ects;
    private int brojPredavanja;
    private int brojVjezbi;
    private String opis;
    private List<GrupaTermina> grupe;
    private List<Kabinet> kabineti;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "naziv")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "ects")
    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Basic
    @Column(name = "brojPredavanja")
    public int getBrojPredavanja() {
        return brojPredavanja;
    }

    public void setBrojPredavanja(int brojPredavanja) {
        this.brojPredavanja = brojPredavanja;
    }

    @Basic
    @Column(name = "brojVjezbi")
    public int getBrojVjezbi() {
        return brojVjezbi;
    }

    public void setBrojVjezbi(int brojVjezbi) {
        this.brojVjezbi = brojVjezbi;
    }

    @Basic
    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


    @OneToMany(mappedBy = "predmet")
    public List<GrupaTermina> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<GrupaTermina> grupe) {
        this.grupe = grupe;
    }

    @ManyToMany(mappedBy = "predmeti")
    public List<Kabinet> getKabineti() {
        return kabineti;
    }

    public void setKabineti(List<Kabinet> kabineti) {
        this.kabineti = kabineti;
    }
}
