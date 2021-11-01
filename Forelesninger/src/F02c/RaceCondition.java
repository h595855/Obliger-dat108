package F02c;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		final int n = 100000;
		
		Teller teller = new Teller();
		
		Thread telloppTraad = new TellerOppTraad(teller, n);
		Thread tellnedTraad = new TellerNedTraad(teller, n);
		
		telloppTraad.start();
		tellnedTraad.start();
		
		telloppTraad.join();
		tellnedTraad.join();
		
		System.out.println("ferdig.... tellerverdi = " + teller.getVerdi());
		
		
		
	}

}
