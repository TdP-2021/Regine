package it.polito.tdp.regine.model;

import java.util.List;

public class TestRegine {
	public static void main(String args[]) {
		Regine r = new Regine();
		List<Integer> regine;
		
		regine = r.disponiRegine();
		System.out.println("(c, r)");
		for(int i=0; i<7; i++)
			System.out.println("(" + i + ", " + regine.get(i) + ")");
	}
}
