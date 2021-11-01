package F03BussyWaitmelding;

public class Melding {

	private String tekst;

	public synchronized String getTekst() {

		while (!harTekst()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		return tekst;
	}

	public synchronized void setTekst(String tekst) {
		this.tekst = tekst;
		notifyAll();

	}

	public boolean harTekst() {
		return tekst != null;
	}

}
