package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.ADT.FilmarkivADT;

public class Fil {
	final static String skille = "#";
	
	public static void lesFraFil(FilmarkivADT filmarkiv, String filnavn) {
		FileReader fil = null;
		BufferedReader innfil = null;
		
		
		try {
			fil = new FileReader(filnavn);
			
		}catch(FileNotFoundException unntak){
		System.out.println("piss");
	}
		try {
		
			int antPost = 6;
			
			
			innfil = new BufferedReader(fil);
			
			String linje = innfil.readLine();
			for(int i = 0; i < antPost; i++) {
				String[] felt = linje.split(skille);
			
			
			int filmnr = Integer.parseInt(felt[0]);
			String selsk = felt[1];
			String tittel = felt[2];
			Sjanger sjang = Sjanger.valueOf(felt[3]);
			int år = Integer.parseInt(felt[4]);
			String prod = felt[5];
			
			Film a = new Film(filmnr, selsk, tittel, år, sjang, prod);
			System.out.println(a);
			
			filmarkiv.leggTilFilm(a);
			}
			innfil.close();
			
		}	catch(IOException e) {
			System.out.println("synd");
			System.exit(2);
		}
		
	}  
	
	
	public static void skrivTilFil(FilmarkivADT filmarkiv, String filnavn) {
		final String skille = ":";
		final String Film_fil = "filnavn";
		
		int antall = filmarkiv.antall();
		
		try {
			FileWriter filmfil = new FileWriter(Film_fil, false);
			
			PrintWriter utfil = new PrintWriter(filmfil);
			
			utfil.println(antall);
			
			utfil.print(filmarkiv.hentFilmTabell()); utfil.print(skille);
			
			utfil.close();
			
			
		} catch (IOException e) {
            System.out.println("Feil ved skriving til fil : " + e);
            System.exit(3);
        }
	}
}
