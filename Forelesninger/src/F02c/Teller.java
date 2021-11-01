package F02c;

public class Teller {

	public int verdi = 0;
	
	public void tellOpp() {
		synchronized(this) {
			verdi++;
		}
	}
	
	public void tellNed() {
		synchronized(this) {
			verdi--;			
		}
	}
	public int getVerdi() {
		return verdi;
	}
}
