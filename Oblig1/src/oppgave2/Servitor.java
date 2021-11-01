package oppgave2;

import java.util.concurrent.atomic.AtomicInteger;

public class Servitor extends Thread {

	private static AtomicInteger at = new AtomicInteger(0);

	private String navn;
	private HamburgerBrett brett;

	public Servitor(String navn, HamburgerBrett brett) {
		this.navn = navn;
		this.brett = brett;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(2000);
				fjernBurger();
			} catch (InterruptedException e) {
			}
		}
	}

	public void fjernBurger() throws InterruptedException {

		synchronized (brett) {
			if (brett.erTom()) {
				System.out.println(navn + " (servitør) ønsker å ta av hamburger, men brettet er tomt. Venter");
				brett.wait();
			}
		}

		synchronized (brett) {
			brett.fjernBurger();
			System.out.println(
					navn + " (Servitør) la legger av hambuger ◖" + at.incrementAndGet() + "◗. Brett " + brett.toString());
			brett.notifyAll();
		}
	}

}
