package com.example.echo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kabinet {
    private int idKabinet;
    private Integer kapacitet;
    private String namjena;
    private List<Raspored> termini;
    private List<Predmet> predmeti;

    @Id
    @Column(name = "idKabinet")
    public int getIdKabinet() {
        return idKabinet;
    }

    public void setIdKabinet(int idKabinet) {
        this.idKabinet = idKabinet;
    }

    @Basic
    @Column(name = "kapacitet")
    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Basic
    @Column(name = "namjena")
    public String getNamjena() {
        return namjena;
    }

    public void setNamjena(String namjena) {
        this.namjena = namjena;
    }


    @OneToMany(mappedBy = "kabinet")
    public List<Raspored> getTermini() {
        return termini;
    }

    public void setTermini(List<Raspored> termini) {
        this.termini = termini;
    }

    @ManyToMany
    @JoinTable(name = "predmet_kabinet", catalog = "", schema = "TYQcLL35gV", joinColumns = @JoinColumn(name = "idKabinet", referencedColumnName = "idKabinet"), inverseJoinColumns = @JoinColumn(name = "idPredmet", referencedColumnName = "id"))
    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }
}
