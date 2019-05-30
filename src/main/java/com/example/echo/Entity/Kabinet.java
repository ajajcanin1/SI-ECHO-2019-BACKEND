package com.example.echo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Kabinet {
    private int idKabinet;
    private Integer kapacitet;
    private String naziv;
    private Boolean namjena;
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
    @Column(name = "naziv")
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    @Basic
    @Column(name = "namjena")
    public Boolean getNamjena() {
        return namjena;
    }

    public void setNamjena(Boolean namjena) {
        this.namjena = namjena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kabinet kabinet = (Kabinet) o;

        if (idKabinet != kabinet.idKabinet) return false;
        if (kapacitet != null ? !kapacitet.equals(kabinet.kapacitet) : kabinet.kapacitet != null) return false;
        if (naziv != null ? !naziv.equals(kabinet.naziv) : kabinet.naziv != null) return false;
        if (namjena != null ? !namjena.equals(kabinet.namjena) : kabinet.namjena != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idKabinet;
        result = 31 * result + (kapacitet != null ? kapacitet.hashCode() : 0);
        result = 31 * result + (namjena != null ? namjena.hashCode() : 0);
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        return result;
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
