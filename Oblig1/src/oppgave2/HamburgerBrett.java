package oppgave2;

import java.util.ArrayList;

public class HamburgerBrett {

	private int Kapasitet;
	private ArrayList<Hamburger> Hamburger = new ArrayList<Hamburger>();

	public HamburgerBrett(int Kapasitet) {
		this.Kapasitet = Kapasitet;

	}

	public int antallBurgere() {
		return Hamburger.size();
	}

	public void leggTilBurger(Hamburger hamburger) {
		if (Hamburger.size() < Kapasitet) {
			Hamburger.add(hamburger);
		}
	}

	public boolean erFull() {
		return Hamburger.size() == Kapasitet;
	}

	public boolean erTom() {
		return Hamburger.size() == 0;
	}

	public void fjernBurger() {
		Hamburger.remove(0);
	}

	@Override
	public String toString() {
		return " " + Hamburger;
	}
}
