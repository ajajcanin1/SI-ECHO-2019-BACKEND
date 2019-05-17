package com.example.echo.DTO;

import java.util.ArrayList;

public class Algorithm {
    private ArrayList<Schedule> chromosomes;
    private ArrayList<Boolean> bestFlags;
    private ArrayList<Integer> bestChromosomes;
    private Integer currentBestiSize;
    private Integer replaceByGeneration;
    private Schedule prototype;
    private Integer currentGeneration;
    private AlgorithmState state;

    //ako bude trebalo dodati ostale atribute -> vidjeti algoritam
    public Algorithm getInstance() {
        return this;
    }
    //DODATI METODE

}
