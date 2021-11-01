package oppgave1;

import javax.swing.JOptionPane;

public class Skriv implements Runnable {

	static String tekst;
	
	public static String getTekst() {
		return tekst;
	}
	
	@Override
	public void run() {
		tekst = "Hallo verden!";
		while(!(tekst.equals("QUIT"))) {
			tekst = JOptionPane.showInputDialog("Skriv inn melding her, QUIT for å avslutte");
			System.out.println(tekst);
		}
		
	}

}
