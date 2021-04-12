package it.polito.tdp.regine.model;

import java.util.List;

public class TestRegine {
	public static void main(String args[]) {
		Regine r = new Regine();
		List<List<Integer>> soluzioni;
		//regine = r.disponiRegine(N);
		soluzioni = r.risolvi(6);
		/*if(regine != null) {
			System.out.println("(c, r)");
			for(int i=0; i<N; i++) 
				System.out.println("("+i+", "+regine.get(i)+")");
		}
		else
			System.out.println("Problema senza soluzione");*/
		System.out.println(soluzioni);
	}
}
