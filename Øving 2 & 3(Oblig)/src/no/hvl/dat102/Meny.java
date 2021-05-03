package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Meny {
	private TekstGrensesnitt tekstgr;
	private FilmarkivADT filma;
	
	public Meny(FilmarkivADT filma) {
		this.filma = filma;
		tekstgr = new TekstGrensesnitt();
	}
	
	public void start() {
		
		System.out.println("***************************");
		System.out.println("Velg eit av alternativer");
		System.out.println("Alternativ 1: Legg til Film i tabell");
		System.out.println("Alternativ 2: slett film med filmnummer");
		System.out.println("Alternativ 3: Søk etter tittel");
		System.out.println("Alternativ 4: Antall filmer");
		System.out.println("Alternativ 5: Antall filmer med sjanger");		
		System.out.println("Alternativ 6: Søk etter produsent");		
		System.out.println("***************************");
		
		Scanner scan = new Scanner(System.in);
		
		int input = scan.nextInt();
		
		if(input == 1) {
			filma.leggTilFilm(tekstgr.lesFilm());
			System.out.println("*************************** \n      Film lagt til \n***************************");
			start();
		}
		else if(input == 2) {
			System.out.println("Skriv inn film nr");
			int nr = scan.nextInt();
			filma.slettFilm(nr);
			System.out.println("Filmen er slettet");
			start();
		}
		else if(input == 3) {
			Scanner ny2 = new Scanner(System.in);
			System.out.println("Søk tittel");
			String ny = ny2.next();
//			String ny = scan.next();
			tekstgr.skrivUtFilmDelstrengITittel(filma, ny);
			start();
		}
		
		else if(input == 4) {
			System.out.println(filma.antall());
			start();
		
		}
		else if(input == 5) {
			System.out.println("Skriv Sjanger ");
			String sjang = scan.next();
			System.out.println("Filmer med " + sjang);
			System.out.println(filma.antall(Sjanger.valueOf(sjang.toUpperCase())));
			start();
		}
		
		else if(input == 6) {
			System.out.println("Skriv Produsent");
			String ny = scan.next();
			tekstgr.skrivUtFilmProdusent(filma, ny);
			start();
		}
	}
}
