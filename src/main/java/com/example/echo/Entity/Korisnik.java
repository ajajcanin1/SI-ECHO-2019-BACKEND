package com.example.echo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Entity
public class Korisnik {
    private int id;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String jmbg;
    private String email;
    private String mjestoRodjenja;
    private String kanton;
    private String drzavljanstvo;
    private String telefon;
    private Boolean spol;
    private String imePrezimeMajke;
    private String imePrezimeOca;
    private String adresa;
    private String username;
    private String password;
    private String linkedin;
    private String website;
    private byte[] fotografija;
    private String indeks;
    private String ciklus;
    private String semestar;
    private String titula;
    private List<GrupaTermina> grupe;
    private List<ZeljeniTermin> zeljeniTermini;
    private Uloga uloga;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ime")
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "prezime")
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "datumRodjenja")
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Basic
    @Column(name = "JMBG")
    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "mjestoRodjenja")
    public String getMjestoRodjenja() {
        return mjestoRodjenja;
    }

    public void setMjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja = mjestoRodjenja;
    }

    @Basic
    @Column(name = "kanton")
    public String getKanton() {
        return kanton;
    }

    public void setKanton(String kanton) {
        this.kanton = kanton;
    }

    @Basic
    @Column(name = "drzavljanstvo")
    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    @Basic
    @Column(name = "telefon")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Basic
    @Column(name = "spol")
    public Boolean getSpol() {
        return spol;
    }

    public void setSpol(Boolean spol) {
        this.spol = spol;
    }

    @Basic
    @Column(name = "imePrezimeMajke")
    public String getImePrezimeMajke() {
        return imePrezimeMajke;
    }

    public void setImePrezimeMajke(String imePrezimeMajke) {
        this.imePrezimeMajke = imePrezimeMajke;
    }

    @Basic
    @Column(name = "imePrezimeOca")
    public String getImePrezimeOca() {
        return imePrezimeOca;
    }

    public void setImePrezimeOca(String imePrezimeOca) {
        this.imePrezimeOca = imePrezimeOca;
    }

    @Basic
    @Column(name = "adresa")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "linkedin")
    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @Basic
    @Column(name = "website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "fotografija")
    public byte[] getFotografija() {
        return fotografija;
    }

    public void setFotografija(byte[] fotografija) {
        this.fotografija = fotografija;
    }

    @Basic
    @Column(name = "indeks")
    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    @Basic
    @Column(name = "ciklus")
    public String getCiklus() {
        return ciklus;
    }

    public void setCiklus(String ciklus) {
        this.ciklus = ciklus;
    }

    @Basic
    @Column(name = "semestar")
    public String getSemestar() {
        return semestar;
    }

    public void setSemestar(String semestar) {
        this.semestar = semestar;
    }

    @Basic
    @Column(name = "titula")
    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }


    @OneToMany(mappedBy = "predavac")
    public List<GrupaTermina> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<GrupaTermina> grupe) {
        this.grupe = grupe;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "predavac")
    public List<ZeljeniTermin> getZeljeniTermini() {
        return zeljeniTermini;
    }

    public void setZeljeniTermini(List<ZeljeniTermin> zeljeniTermini) {
        this.zeljeniTermini = zeljeniTermini;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "idUloga", referencedColumnName = "idUloga", nullable = false)
    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }
}
