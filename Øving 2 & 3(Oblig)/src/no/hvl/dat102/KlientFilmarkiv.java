package no.hvl.dat102;

import no.hvl.dat102.ADT.FilmarkivADT;

public class KlientFilmarkiv {

	public static void main(String[] args) {
		
		Film Fast = new Film(1, "Fastmovies", "Fast", 01004 , Sjanger.HISTORY, "flask PRODUCTIONS");
		Film Fast2 = new Film(2, "Fastmovies", "Fast2", 2006, Sjanger.HISTORY, "flask PRODUCTIONS");
		Film Fast3 = new Film(3, "Fastmovies", "Fast3", 2007, Sjanger.HISTORY, "flask PRODUCTIONS");
		Film Fast4 = new Film(4, "Fastmovies", "Fast4: Cock gobler", 2008, Sjanger.ACTION, "flask PRODUCTIONS");
		
		
		FilmarkivADT Faster = new Filmarkiv2();
		Faster.leggTilFilm(Fast);
		Faster.leggTilFilm(Fast2);
		Faster.leggTilFilm(Fast3);
		Faster.leggTilFilm(Fast4);
		
		// meny til filmarkiv
		Meny meny = new Meny(Faster);
		meny.start();
		
	}

}
