package com.example.echo.DTO;

import java.util.ArrayList;

public class Algorithm {
    public enum AlgorithmState
    {
    AS_USER_STOPED,
    AS_CRITERIA_STOPPED,
    AS_RUNNING
    };
    private ArrayList<Schedule> chromosomes = new ArrayList<>();
    private ArrayList<Boolean> bestFlags = new ArrayList<>();
    private ArrayList<Integer> bestChromosomes = new ArrayList<>();
    private Integer currentBestSize;
    private Integer replaceByGeneration;
    private Schedule prototype;
    private Integer currentGeneration;
    private AlgorithmState state;

    //ako bude trebalo dodati ostale atribute -> vidjeti algoritam
    public Algorithm getInstance() {
        return this;
    }
    //DODATI METODE
    //inicijalizacija genetickog algoritma
    public Algorithm(int numberOfChromosomes, int replaceByGeneration, int trackBest, Schedule prototype) {
        this.replaceByGeneration = replaceByGeneration;
        this.currentBestSize = 0;
        this.prototype = prototype;
        this.currentGeneration = 0;
        this.state = AlgorithmState.AS_USER_STOPED;

	if( numberOfChromosomes < 2 )
        numberOfChromosomes = 2;
        
	if( trackBest < 1 )
		trackBest = 1;

	if(replaceByGeneration < 1 )
    replaceByGeneration = 1;
    
	else if( replaceByGeneration > numberOfChromosomes - trackBest )
	replaceByGeneration = numberOfChromosomes - trackBest;

  
	chromosomes.ensureCapacity( numberOfChromosomes );
	bestFlags.ensureCapacity( numberOfChromosomes );
	bestChromosomes.ensureCapacity(trackBest );

	for( int i = 0; i < numberOfChromosomes; i++)
	{
        Schedule x = new Schedule(0,0,0,0);
		chromosomes.add(i, x);
		bestFlags.add(i, false);
    }
}
    //vrati true ako hromosom pripada grupi najbolji hromosom
    public boolean IsInBest(int ChromosomeIndex){
        return bestFlags.contains(bestFlags.get(ChromosomeIndex));
    }
    //clear best chromosome group
    public void ClearBest(){
        for(int i = bestFlags.size() - 1; i >= 0; --i){
            bestFlags.set(i, false);
        }
        currentBestSize = 0;
    }
}
