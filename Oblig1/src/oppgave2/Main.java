package oppgave2;

public class Main {

	public static void skrivUtHeader(String[] kokker, String[] servitorer, int Kapasitet) {
		System.out.println("I denne simuleringen har vi");
		System.out.print("        " + kokker.length + " kokker [");
		for (int i = 0; i < kokker.length; i++) {
			
			if(kokker.length-1 == i) {
				System.out.print(kokker[i]);
			}else {
				System.out.print(kokker[i] + ", ");
			}
			
		}
		System.out.println("]");

		System.out.print("        " + servitorer.length + " Servitører [" );
		for (int i = 0; i < servitorer.length; i++) {
			
			if(servitorer.length-1 == i) {
				System.out.print(servitorer[i]);
			}else {
				System.out.print(servitorer[i] + ", ");	
			}
		}
		System.out.println("]");
		System.out.println("        " + "Kapasiteten på brettet er " + Kapasitet + " Burgere" + "\n Vi starter ...");
	}


	public static void main(String[] args) {
		
		
		final String[] kokker = { "Karina", "Iris", "Anton" };
		final String[] servitorer = { "Alfred", "Bjorn" };

		final int KAPASITET = 4;

		skrivUtHeader(kokker, servitorer, KAPASITET);

		HamburgerBrett brett = new HamburgerBrett(KAPASITET);

		for (String navn : kokker) {
			new Kokk(navn, brett).start();
		}

		for (String navn : servitorer) {
			new Servitor(navn, brett).start();
		}
	}

}
