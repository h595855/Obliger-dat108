package no.hvl.dat100;

import static java.lang.Integer.*;
import static javax.swing.JOptionPane.*;

public class Karakterer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 10; i++) {
		
		int Poeng = parseInt(showInputDialog("Skriv inn Poeng: "));
	
		
		if (Poeng >= 0 && Poeng <= 39) {
			showMessageDialog(null, "Karakter F");
		
		}else if ( Poeng > 39 && Poeng <= 49){
			showMessageDialog(null, "Karakter E");
		
		}else if ( Poeng > 49 && Poeng <= 59){
			showMessageDialog(null, "Karakter D");
		
		}else if ( Poeng > 59 && Poeng <= 79){
			showMessageDialog(null, "Karakter C");
		
		}else if ( Poeng > 79 && Poeng <= 89){
			showMessageDialog(null, "Karakter B");
		
		}else if ( Poeng > 89 && Poeng <= 100){
			showMessageDialog(null, "Karater A");
			
		}else {
			showMessageDialog(null, "ikke mulig");
		
		
		     }
		}
			
	}

}
