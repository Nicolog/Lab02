package it.polito.tdp.alien.model;

import java.util.LinkedList;

public class Parola {

	
	private String parola;
	private LinkedList<String> traduzioni;
	
	public Parola(String parola) {
	
		this.parola = parola;
		traduzioni = new LinkedList<String>();
	}

	public LinkedList<String> getTraduzioni() {
		return traduzioni;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}
	
}
