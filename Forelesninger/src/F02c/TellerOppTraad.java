package F02c;

public class TellerOppTraad extends Thread {

	private Teller teller;
	private int n;

	public TellerOppTraad(Teller teller, int n) {
		this.teller = teller;
		this.n = n;
	}

	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
		
				teller.tellOpp();
			
		}
	}
}
