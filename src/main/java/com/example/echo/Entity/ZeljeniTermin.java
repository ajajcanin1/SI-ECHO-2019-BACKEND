package com.example.echo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ZeljeniTermin {
    private int idZeljeniTermin;
    private Integer idKabinet;
    private String danUSedmici;
    private Timestamp vrijeme;
    private Korisnik predavac;

    @Id
    @Column(name = "idZeljeniTermin")
    public int getIdZeljeniTermin() {
        return idZeljeniTermin;
    }

    public void setIdZeljeniTermin(int idZeljeniTermin) {
        this.idZeljeniTermin = idZeljeniTermin;
    }

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
    public Timestamp getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Timestamp vrijeme) {
        this.vrijeme = vrijeme;
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
