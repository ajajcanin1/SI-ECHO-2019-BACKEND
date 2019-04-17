package com.example.echo.Entity;

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
    private List<PredmetKabinet> kabineti;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Predmet predmet = (Predmet) o;

        if (id != predmet.id) return false;
        if (ects != predmet.ects) return false;
        if (brojPredavanja != predmet.brojPredavanja) return false;
        if (brojVjezbi != predmet.brojVjezbi) return false;
        if (naziv != null ? !naziv.equals(predmet.naziv) : predmet.naziv != null) return false;
        if (opis != null ? !opis.equals(predmet.opis) : predmet.opis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + ects;
        result = 31 * result + brojPredavanja;
        result = 31 * result + brojVjezbi;
        result = 31 * result + (opis != null ? opis.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "predmet")
    public List<GrupaTermina> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<GrupaTermina> grupe) {
        this.grupe = grupe;
    }

    @OneToMany(mappedBy = "predmet")
    public List<PredmetKabinet> getKabineti() {
        return kabineti;
    }

    public void setKabineti(List<PredmetKabinet> kabineti) {
        this.kabineti = kabineti;
    }
}
