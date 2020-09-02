package no.hvl.dat100;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;


public class Skatt {
	

	public static void main(String[] args) {
		// Skrive inn Bruttolønn
		int Lønn = parseInt(showInputDialog("Skriv inn BruttoLønn: "));
	
		
		if (Lønn <= 180500) {
			showMessageDialog(null, "Ingen trekk");
		}else if ( Lønn > 180500 && Lønn <= 254500){
			showMessageDialog(null, "Trinn 1 skatt: " + Lønn * 0.019);
		
		}else if ( Lønn > 254500 && Lønn <= 639750){
			showMessageDialog(null, "Trinn 2 skatt: " + Lønn * 0.042);
		
		}else if ( Lønn > 639750 && Lønn <= 999550){
			showMessageDialog(null, "Trinn 3 skatt: " + Lønn * 0.132);
		
		}else if ( Lønn > 999550){
			showMessageDialog(null, "Trinn 4 skatt: " + Lønn * 0.162);
		}
			
			
		}
		
	}
	

	
			
			
