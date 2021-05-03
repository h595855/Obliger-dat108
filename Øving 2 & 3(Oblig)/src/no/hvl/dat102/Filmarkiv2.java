package no.hvl.dat102;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
	LinearNode<Film> start = new LinearNode<>();	
	}
	
	@Override
	public Film[] hentFilmTabell() {
		
		Film[] hjelpetab = new Film[antall];
		
		LinearNode<Film> nyNod = start;
		
		for(int i = 0; i < antall; i++) {
			hjelpetab[i] = start.getElement();
			
			nyNod = nyNod.getNeste();
			
		}
		return hjelpetab;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		
		LinearNode<Film> nyNod = new LinearNode<Film>(nyFilm);
		
		nyNod.setNeste(start);
		
		start = nyNod;
		
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		LinearNode<Film> p = start;
		LinearNode<Film> forrige = null;

		while(p != null && !slettet) {
			if(start.getElement().getFilmnr() == filmnr) {
				start = forrige;
				start.setNeste(p.getNeste());
				antall--;
				slettet = true;
				
			}else if(p.getElement().getFilmnr() == filmnr) {
					forrige.setNeste(p.getNeste());
					antall--;
					slettet = true;
			}else{
				forrige = p;
				p = p.getNeste();
				
				}
			}
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		
		Film[] hjelpetab = new Film[antall];
		
		LinearNode<Film> nyNod = start;
		
		for(int i = 0; i < antall; i++) {
			if(nyNod.getElement().getTittel().contains(delstreng)) {
				
				hjelpetab[i] = nyNod.getElement();
			
			}
				nyNod = nyNod.getNeste();
		}
		return hjelpetab;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] hjelpetab = new Film[antall];
		
		LinearNode<Film> nyNod = start;
		
		for(int i = 0; i < antall; i++) {
			if(nyNod.getElement().getProdusent().contains(delstreng)) {
				hjelpetab[i] = nyNod.getElement();
			}
				nyNod = nyNod.getNeste();
		}
		return hjelpetab;
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> nyNode = start;
		int counter = 0;
		int i =0;
		
		while(i < antall) {
			i++;
			
			if(nyNode.getElement().getSjanger().equals(sjanger)) {			
			counter++;
			}			
			nyNode = nyNode.getNeste();
		}

		return counter;		
	}

	@Override
	public int antall() {
		return antall;
	}

}
