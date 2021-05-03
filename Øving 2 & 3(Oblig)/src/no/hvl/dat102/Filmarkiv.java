package no.hvl.dat102;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{
	
	private Film[] filmTabell;
	private int antall;
	
	
	public Filmarkiv(int lengde) {
			filmTabell  = new Film[lengde];
			antall = 0;
	}

	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(antall == filmTabell.length) {
			utvidKapasitet();
		}
		filmTabell[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmrn) {
		boolean slettet = false;
		for(int i = 0; i < antall; i++) {
		if(filmTabell[i].getFilmnr() == filmrn) {
			filmTabell[i] = null;
			filmTabell[i] = filmTabell[antall - 1];
			antall--;
			slettet = true;
			}
		}
		return slettet;
		
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] Tab = new Film[antall];
		int count = 0;
		for(int i = 0; i < antall; i++) {
			if(filmTabell[i].getTittel().contains(delstreng)) {
				Tab[count] = filmTabell[i];
				count++;
			}
		}
		return Tab;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tab = new Film[antall];
		int count = 0;
		for(int i = 0; i < antall; i++) {
			if(filmTabell[i].getProdusent().contains(delstreng)) {
				tab[count] = filmTabell[i];
				count++;
			}
		}
		return tab;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		for(int i = 0; i < antall; i++) {
			if(filmTabell[i].getSjanger() == sjanger) {
				antall++;
			}
		}
		return antall;
	}

	@Override
	public int antall() {
		return antall;
		
	}
	
	private void utvidKapasitet() {
		Film[] hjelpetabell = new Film[antall + 1];
		for(int i = 0; i < filmTabell.length; i++) {
			hjelpetabell[i] = filmTabell[i];
		}
		filmTabell = hjelpetabell;
	}

}
