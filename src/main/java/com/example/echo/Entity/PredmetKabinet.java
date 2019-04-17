package com.example.echo.Entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "predmet_kabinet", schema = "TYQcLL35gV", catalog = "")
public class PredmetKabinet {
    private Kabinet kabinet;
    private Predmet predmet;

    @ManyToOne
    @JoinColumn(name = "idKabinet", referencedColumnName = "idKabinet")
    public Kabinet getKabinet() {
        return kabinet;
    }

    public void setKabinet(Kabinet kabinet) {
        this.kabinet = kabinet;
    }

    @ManyToOne
    @JoinColumn(name = "idPredmet", referencedColumnName = "id")
    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }
}
