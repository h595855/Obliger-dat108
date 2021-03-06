package sendermottaker;

public class Mottaker extends Thread {

	private Melding melding;
	
	public Mottaker(Melding melding) {
		this.melding = melding;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				sleep(10000);
			} catch (InterruptedException e) {
			}
			
			synchronized(melding) {
			while(melding.erMeldingLest()) {
				try {
					melding.wait();
				} catch (InterruptedException e) {
				}
			}
			String motattTekst = melding.getTekst();
			melding.notifyAll();		
			System.out.println("Mottaker har mottat melding " + motattTekst);
			}
			
		}
	}

}
