package no.hvl.dat100;
	
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;


public class Fakultet {

	public static void main(String[] args) {

		int n = parseInt(showInputDialog("Skriv fakutliet: "));

		int fak = 1;
			
		for(;n > 0; n--) {
					
			fak = fak * n;
					
			System.out.println(fak);
				
		
	 }			
		
   }
}
