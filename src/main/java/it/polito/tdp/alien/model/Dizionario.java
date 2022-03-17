package it.polito.tdp.alien.model;

import java.util.*;

public class Dizionario {

	private Map<String, Parola> dizionario;
	
	public Dizionario() {
		dizionario = new TreeMap<String, Parola>();  // TreeMap dati ordinati 
	}
	
	public void add(Parola p) {
			dizionario.put(p.getParola(), p );
	}
	
	public LinkedList<String> search(String s) {
		
		for(String ss : dizionario.keySet())
			if(ss.equals(s))
				return dizionario.get(ss).getTraduzioni();
		
		return null;
	}

	@Override
	public String toString() {
		return "Dizionario [dizionario=" + dizionario + "]";
	}

	public Map<String, Parola> getDizionario() {
		return dizionario;
	}
	
	
}
