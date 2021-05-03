package no.hvl.dat102.ADT;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {
	
	// Returnere en tabell av Filmer
	Film[] hentFilmTabell();
	
	// Legger til en ny film
	void leggTilFilm(Film nyFilm);
	
	// Sletter en Film hvis den finnes
	boolean slettFilm(int filmrn);
	
	// Søker og henter filmer med en gitt delstreng
	Film[] soekTittel(String delstreng);
	
	//soker og henter produsenter ked en gitt delstreng
	Film[] soekProdusent(String delstreng);
	
	//henter antall filmer med gitt sjanger
	int antall (Sjanger sjanger);
	
	// Returnere antall Filmer
	int antall();
	
	
}	//Interface
