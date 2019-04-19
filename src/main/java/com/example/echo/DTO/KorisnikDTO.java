package com.example.echo.DTO;

public class KorisnikDTO {

    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String titula;

    public KorisnikDTO(int id, String ime, String prezime, String email, String titula) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.titula = titula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitula() {
        return titula;
    }

    public void setTitula(String titula) {
        this.titula = titula;
    }
}
