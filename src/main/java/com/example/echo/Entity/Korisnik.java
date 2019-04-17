package com.example.echo.Entity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Korisnik korisnik = (Korisnik) o;

        if (id != korisnik.id) return false;
        if (ime != null ? !ime.equals(korisnik.ime) : korisnik.ime != null) return false;
        if (prezime != null ? !prezime.equals(korisnik.prezime) : korisnik.prezime != null) return false;
        if (datumRodjenja != null ? !datumRodjenja.equals(korisnik.datumRodjenja) : korisnik.datumRodjenja != null)
            return false;
        if (jmbg != null ? !jmbg.equals(korisnik.jmbg) : korisnik.jmbg != null) return false;
        if (email != null ? !email.equals(korisnik.email) : korisnik.email != null) return false;
        if (mjestoRodjenja != null ? !mjestoRodjenja.equals(korisnik.mjestoRodjenja) : korisnik.mjestoRodjenja != null)
            return false;
        if (kanton != null ? !kanton.equals(korisnik.kanton) : korisnik.kanton != null) return false;
        if (drzavljanstvo != null ? !drzavljanstvo.equals(korisnik.drzavljanstvo) : korisnik.drzavljanstvo != null)
            return false;
        if (telefon != null ? !telefon.equals(korisnik.telefon) : korisnik.telefon != null) return false;
        if (spol != null ? !spol.equals(korisnik.spol) : korisnik.spol != null) return false;
        if (imePrezimeMajke != null ? !imePrezimeMajke.equals(korisnik.imePrezimeMajke) : korisnik.imePrezimeMajke != null)
            return false;
        if (imePrezimeOca != null ? !imePrezimeOca.equals(korisnik.imePrezimeOca) : korisnik.imePrezimeOca != null)
            return false;
        if (adresa != null ? !adresa.equals(korisnik.adresa) : korisnik.adresa != null) return false;
        if (username != null ? !username.equals(korisnik.username) : korisnik.username != null) return false;
        if (password != null ? !password.equals(korisnik.password) : korisnik.password != null) return false;
        if (linkedin != null ? !linkedin.equals(korisnik.linkedin) : korisnik.linkedin != null) return false;
        if (website != null ? !website.equals(korisnik.website) : korisnik.website != null) return false;
        if (!Arrays.equals(fotografija, korisnik.fotografija)) return false;
        if (indeks != null ? !indeks.equals(korisnik.indeks) : korisnik.indeks != null) return false;
        if (ciklus != null ? !ciklus.equals(korisnik.ciklus) : korisnik.ciklus != null) return false;
        if (semestar != null ? !semestar.equals(korisnik.semestar) : korisnik.semestar != null) return false;
        if (titula != null ? !titula.equals(korisnik.titula) : korisnik.titula != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (prezime != null ? prezime.hashCode() : 0);
        result = 31 * result + (datumRodjenja != null ? datumRodjenja.hashCode() : 0);
        result = 31 * result + (jmbg != null ? jmbg.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mjestoRodjenja != null ? mjestoRodjenja.hashCode() : 0);
        result = 31 * result + (kanton != null ? kanton.hashCode() : 0);
        result = 31 * result + (drzavljanstvo != null ? drzavljanstvo.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (spol != null ? spol.hashCode() : 0);
        result = 31 * result + (imePrezimeMajke != null ? imePrezimeMajke.hashCode() : 0);
        result = 31 * result + (imePrezimeOca != null ? imePrezimeOca.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (linkedin != null ? linkedin.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(fotografija);
        result = 31 * result + (indeks != null ? indeks.hashCode() : 0);
        result = 31 * result + (ciklus != null ? ciklus.hashCode() : 0);
        result = 31 * result + (semestar != null ? semestar.hashCode() : 0);
        result = 31 * result + (titula != null ? titula.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "predavac")
    public List<GrupaTermina> getGrupe() {
        return grupe;
    }

    public void setGrupe(List<GrupaTermina> grupe) {
        this.grupe = grupe;
    }

    @OneToMany(mappedBy = "predavac")
    public List<ZeljeniTermin> getZeljeniTermini() {
        return zeljeniTermini;
    }

    public void setZeljeniTermini(List<ZeljeniTermin> zeljeniTermini) {
        this.zeljeniTermini = zeljeniTermini;
    }
}
