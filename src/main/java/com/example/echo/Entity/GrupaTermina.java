package com.example.echo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class GrupaTermina {
    private int idGrupaTermina;
    private String naziv;
    private Korisnik predavac;
    private Predmet predmet;
    private List<Raspored> termini;

    @Id
    @Column(name = "idGrupaTermina")
    public int getIdGrupaTermina() {
        return idGrupaTermina;
    }

    public void setIdGrupaTermina(int idGrupaTermina) {
        this.idGrupaTermina = idGrupaTermina;
    }

    @Basic
    @Column(name = "naziv")
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @ManyToOne
    @JoinColumn(name = "idPredavac", referencedColumnName = "id", nullable = false)
    public Korisnik getPredavac() {
        return predavac;
    }

    public void setPredavac(Korisnik predavac) {
        this.predavac = predavac;
    }

    @ManyToOne
    @JoinColumn(name = "idPredmet", referencedColumnName = "id", nullable = false)
    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    @OneToMany(mappedBy = "grupa")
    public List<Raspored> getTermini() {
        return termini;
    }

    public void setTermini(List<Raspored> termini) {
        this.termini = termini;
    }
}
