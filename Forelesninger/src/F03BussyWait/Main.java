package F03BussyWait;

import javax.swing.JOptionPane;

public class Main {

	private static String melding;

	public static void main(String[] args) {

		Object lock = new Object();
		
		Thread printlnTraad = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (lock) {
				if(melding == null) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
					}
				}
				System.out.println(melding);
				}
			}
		});

		Thread giVerdiTraad = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lock) {
				melding = "Rull Ekstra schwarma";
				lock.notify();

				}
			}
		});
		printlnTraad.start();
		giVerdiTraad.start();
	}

}
