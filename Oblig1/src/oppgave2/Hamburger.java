package oppgave2;

public class Hamburger {

	private int hamburger;

	public Hamburger(int hamburger) {
		this.hamburger = hamburger;
	}

	public int getHamburger() {
		return hamburger;
	}

	public void setHamburger(int hamburger) {
		this.hamburger = hamburger;
	}

	@Override
	public String toString() {
		return "◖" + hamburger + "◗";
	}

}
