package oppgave2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Kokk extends Thread {

	private static AtomicInteger at = new AtomicInteger(0);
	
	private String navn;
	private HamburgerBrett brett;


	public Kokk(String navn, HamburgerBrett brett) {
		this.navn = navn;
		this.brett = brett;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Random r = new Random();
				Thread.sleep(r.nextInt(Math.max(2000, 6000)));
				lageBurger(at.incrementAndGet());
			}catch(InterruptedException e) {
			}
		}
	}

	public void lageBurger(int i) throws InterruptedException {
		
		synchronized(brett) {
			if(brett.erFull()) {
				System.out.println(navn + " Klar med hamburger, men brettet er fult");
				brett.wait();
			}
		}
		
		synchronized(brett) {
			brett.leggTilBurger(new Hamburger(i));
			System.out.println(navn + " (kokk) legger på hambuger ◖" + i + "◗. Brett " + brett.toString());
			brett.notifyAll();
		}
	}
}
