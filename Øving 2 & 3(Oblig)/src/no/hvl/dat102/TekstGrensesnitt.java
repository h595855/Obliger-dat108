package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.ADT.*;

public class TekstGrensesnitt {
	
	private final String Skille = "#";
	//Lese opplysningene om ein Film Fra tastatur
	public Film lesFilm() {
		
		Film nyFilm = new Film();
		Scanner sc = new Scanner(System.in);
		
		String Films, titt, sjang, prod;
		int år, filmnr;
		
		System.out.println("Film NR");
		filmnr = sc.nextInt();
		
		System.out.println("FilmSelskap");
		Films = sc.next();
		
		System.out.println("Tittel");
		titt = sc.next();
		
		System.out.println("År");
		år = sc.nextInt();
		
		System.out.println("Sjanger");
		sjang = sc.next();
		
		System.out.println("Produsent");
		prod = sc.next();
		
		
		nyFilm.setFilmnr(filmnr);
		nyFilm.setFilmselskap(Films);
		nyFilm.setTittel(titt);
		nyFilm.setÅr(år);
		nyFilm.setSjanger(Sjanger.valueOf(sjang.toUpperCase()));
		nyFilm.setProdusent(prod);
		
		return nyFilm;
	}
	
	
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		 System.out.println(film.toString());
	}
	
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		for (Film ny  : filma.soekTittel(delstreng)) {
			visFilm(ny);
		}
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		for (Film ny : filma.soekProdusent(delstreng)) {
			visFilm(ny);
		}
	}
	
	public void skrivUtStatisitkk(FilmarkivADT filma) {
			System.out.println("Action: " + filma.antall(Sjanger.ACTION) + 
								" Drama: " +	 filma.antall(Sjanger.DRAMA) +
								" Historie: " + filma.antall(Sjanger.HISTORY) + 
								" SCIFY: " + filma.antall(Sjanger.SCIFI));
	}
}
