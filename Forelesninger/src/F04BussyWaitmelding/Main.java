package F04BussyWaitmelding;



public class Main {

	private static String melding;

	public static void main(String[] args) {
		
		Melding melding = new Melding();
		
		Thread printlnTraad = new Thread(new Runnable() {

			@Override
			public void run() {
				melding.getTekst();
			}	
		});

		Thread giVerdiTraad = new Thread(new Runnable() {

			@Override
			public void run() {
				melding.setTekst("Hallo");

					}
			
});
		printlnTraad.start();
		giVerdiTraad.start();

	}
}
