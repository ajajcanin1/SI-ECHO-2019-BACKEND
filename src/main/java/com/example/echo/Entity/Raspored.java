package com.example.echo.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Raspored {
    private int idTermin;
    private String danUsedmici;
    private Timestamp vrijeme;
    private String tipNastave;
    private Kabinet kabinet;
    private GrupaTermina grupa;

    @Id
    @Column(name = "idTermin")
    public int getIdTermin() {
        return idTermin;
    }

    public void setIdTermin(int idTermin) {
        this.idTermin = idTermin;
    }

    @Basic
    @Column(name = "danUsedmici")
    public String getDanUsedmici() {
        return danUsedmici;
    }

    public void setDanUsedmici(String danUsedmici) {
        this.danUsedmici = danUsedmici;
    }

    @Basic
    @Column(name = "vrijeme")
    public Timestamp getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Timestamp vrijeme) {
        this.vrijeme = vrijeme;
    }

    @Basic
    @Column(name = "tipNastave")
    public String getTipNastave() {
        return tipNastave;
    }

    public void setTipNastave(String tipNastave) {
        this.tipNastave = tipNastave;
    }


    @ManyToOne
    @JoinColumn(name = "idKabinet", referencedColumnName = "idKabinet", nullable = false)
    public Kabinet getKabinet() {
        return kabinet;
    }

    public void setKabinet(Kabinet kabinet) {
        this.kabinet = kabinet;
    }

    @ManyToOne
    @JoinColumn(name = "idGrupaTermin", referencedColumnName = "idGrupaTermina", nullable = false)
    public GrupaTermina getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaTermina grupa) {
        this.grupa = grupa;
    }
}
