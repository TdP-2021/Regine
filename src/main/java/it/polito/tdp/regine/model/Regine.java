package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {
	
	public List<Integer> disponiRegine(int N) {
		List<Integer> risultato = new ArrayList<Integer>();
		for(int i=0; i<N; i++)
			risultato.add(-1);
		if(cerca(N, risultato, 0))
			return risultato;
		else
			return null;
	}
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
	
	private boolean cerca(int N, List<Integer>parziale, int livello) {
		if(livello == N) {
			return true;
		}
		else {
			for(int colonna=0; colonna<N; colonna++) {
				// if la possa nella casella [livello][colonna] è valida
				// se sì, aggiungi a parziale e fai ricorsione
				if(!parziale.contains(livello) && livello < N) {
					if(this.valida(N, parziale, colonna, livello)) {
						parziale.set(colonna, livello);
						//System.out.println(""+colonna+","+livello);
						
						if(cerca(N, parziale, livello+1))
							return true;
						
						parziale.set(colonna, -1);
					}
				}
			}
			return false;
		}
	}
	
	private boolean valida(int N, List<Integer>parziale, int colonna, int livello) {
		//controllo colonna
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
	}
	
	
}
