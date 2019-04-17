package com.example.echo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kabinet {
    private int idKabinet;
    private Integer kapacitet;
    private String namjena;
    private List<PredmetKabinet> predmeti;
    private List<Raspored> termini;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kabinet kabinet = (Kabinet) o;

        if (idKabinet != kabinet.idKabinet) return false;
        if (kapacitet != null ? !kapacitet.equals(kabinet.kapacitet) : kabinet.kapacitet != null) return false;
        if (namjena != null ? !namjena.equals(kabinet.namjena) : kabinet.namjena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idKabinet;
        result = 31 * result + (kapacitet != null ? kapacitet.hashCode() : 0);
        result = 31 * result + (namjena != null ? namjena.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kabinet")
    public List<PredmetKabinet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<PredmetKabinet> predmeti) {
        this.predmeti = predmeti;
    }

    @OneToMany(mappedBy = "kabinet")
    public List<Raspored> getTermini() {
        return termini;
    }

    public void setTermini(List<Raspored> termini) {
        this.termini = termini;
    }
}
