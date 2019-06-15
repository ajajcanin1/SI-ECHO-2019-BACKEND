package com.example.echo.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ZeljeniTermin {
    private int idZeljeniTermin;
    private Integer idKabinet;
    private String danUSedmici;
    private String vrijeme;
    private Korisnik predavac;
    private Integer brCasova;

    @Id
    @Column(name = "idZeljeniTermin")
    public int getIdZeljeniTermin() {
        return idZeljeniTermin;
    }

    public void setIdZeljeniTermin(int idZeljeniTermin) {
        this.idZeljeniTermin = idZeljeniTermin;
    }
    @JsonIgnore
    @Basic
    @Column(name = "idKabinet")
    public Integer getIdKabinet() {
        return idKabinet;
    }

    public void setIdKabinet(Integer idKabinet) {
        this.idKabinet = idKabinet;
    }

    @Basic
    @Column(name = "danUSedmici")
    public String getDanUSedmici() {
        return danUSedmici;
    }

    public void setDanUSedmici(String danUSedmici) {
        this.danUSedmici = danUSedmici;
    }

    @Basic
    @Column(name = "vrijeme")
    public String getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }
    @JsonIgnore
    @Basic
    @Column(name = "brCasova")
    public Integer getBrCasova() { return brCasova;}
    public void setBrCasova(Integer brCasova) {
        this.brCasova = brCasova;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZeljeniTermin that = (ZeljeniTermin) o;

        if (idZeljeniTermin != that.idZeljeniTermin) return false;
        if (idKabinet != null ? !idKabinet.equals(that.idKabinet) : that.idKabinet != null) return false;
        if (danUSedmici != null ? !danUSedmici.equals(that.danUSedmici) : that.danUSedmici != null) return false;
        if (brCasova != null ? !brCasova.equals(that.brCasova) : that.brCasova != null) return false;
        if (vrijeme != null ? !vrijeme.equals(that.vrijeme) : that.vrijeme != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZeljeniTermin;
        result = 31 * result + (idKabinet != null ? idKabinet.hashCode() : 0);
        result = 31 * result + (danUSedmici != null ? danUSedmici.hashCode() : 0);
        result = 31 * result + (vrijeme != null ? vrijeme.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idPredavac", referencedColumnName = "id")
    public Korisnik getPredavac() {
        return predavac;
    }

    public void setPredavac(Korisnik predavac) {
        this.predavac = predavac;
    }
}
