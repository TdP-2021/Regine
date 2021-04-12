package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {
	private int N;
	private List<Integer> soluzione;
	/*public List<Integer> disponiRegine(int N) {
		this.N = N;
		List<Integer> risultato = new ArrayList<Integer>();
		for(int i=0; i<N; i++)
			risultato.add(-1);
		if(cerca(risultato, 0))
			return risultato;
		else
			return null;
	}*/
	// N è il numero di righe e colonne della scacchiera
	//   (righe e colonne numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	// 		List<Integer>
	// livello = quante righe sono già piene
	// livello = 0 => nessuna riga piena (devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	// [0]
	//     [0, 2]
	//            [0, 2, 1]
	public List<Integer> risolvi(int N){
		this.N = N;
		List<Integer> parziale = new ArrayList<Integer>();
		this.soluzione = null;
		
		cerca(parziale, 0);
		
		return this.soluzione;
	}
	
	//cerca == true : trovato; cerca == false : cerca ancora
	private boolean cerca(List<Integer> parziale, int livello) {
		if(livello == N) { 
			//caso terminale
			//System.out.println(parziale);
			this.soluzione = new ArrayList<Integer>(parziale);
			return true;
		}
		else {
			for(int colonna=0; colonna<N; colonna++) {
				// if la possa nella casella [livello][colonna] è valida
				// se sì, aggiungi a parziale e fai ricorsione
				
				//List<Integer> parzialeNuovo = new ArrayList<Integer>(parziale);
				//parzialeNuovo.add(colonna);
				//cerca(parzialeNuovo, livello+1);
				
				if(posValida(parziale, colonna)) {
					parziale.add(colonna);
					
					boolean trovato = cerca(parziale, livello+1);
					if(trovato)
						return true;
					
					parziale.remove(parziale.size()-1); //backtracking
				}
			}
			return false;
		}
	}
	private boolean posValida(List<Integer> parziale, int colonna) {
		int livello = parziale.size();
		
		//controlla se viene mangiata in verticale
		if(parziale.contains(colonna))
			return false;
		
		//controlla le diagonali: confrontare la posizione (livello, colonna) con (r, c) delle regine esistenti
		for(int r=0; r<livello; r++) {
			int c = parziale.get(r);
			
			if(r+c == livello+colonna || r-c == livello-colonna)
				return false;
		}
		
		return true;
	}
	
	/*private boolean cerca(List<Integer>parziale, int livello) {
		if(livello == N) { //caso terminale
			return true;
		}
		else {
			for(int colonna=0; colonna<N; colonna++) {
				// if la possa nella casella [livello][colonna] è valida
				// se sì, aggiungi a parziale e fai ricorsione
				if(!parziale.contains(livello) && livello < N) {
					if(this.valida(parziale, colonna, livello)) {
						parziale.set(colonna, livello);
						
						if(cerca(parziale, livello+1))
							return true;
						
						parziale.set(colonna, -1);
					}
				}
			}
			return false;
		}
	}
	
	private boolean valida(List<Integer>parziale, int colonna, int livello) {
		//controllo colonna nella stessa iterazione
		for(int i=0; i<livello; i++)
			if(parziale.get(colonna) == i)
				return false;
		
		//controllo diagonale destra
		int l = livello;
		for(int i = colonna; i < N; i++) {
			if(parziale.get(i) == l && l > -1 && l < N)
				return false;
			l++;
		}
		l = livello;
		for(int i = colonna; i >= 0; i--) {
			if(parziale.get(i) == l && l > -1 && l < N)
				return false;
			l--;
		}
		//controllo diagonale sinistra
		l = livello;
		for(int i = colonna; i >= 0; i--) {
			if(parziale.get(i) == l && l > -1 && l < N)
				return false;
			l++;
		}
		l = livello;
		for(int i = colonna; i < N; i++) {
			if(parziale.get(i) == l && l > -1 && l < N)
				return false;
			l--;
			
		}
		return true;
	}*/
	
	
}
