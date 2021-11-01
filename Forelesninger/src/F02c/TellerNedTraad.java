package F02c;

public class TellerNedTraad extends Thread {
	
	private Teller teller;
	private int n ;
	
	public TellerNedTraad(Teller teller, int n) {
		this.teller = teller;
		this.n = n;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < n; i++) {
			
			teller.tellNed();
			
		}
	}
}
