package oppgave1;


public class Oppgave_1 {

	public static void main(String[] args) {
		
		Thread Skriving = new Thread(new Skriv());
	
		Thread Urtskrift = new Thread(new Runnable() {
				
				@Override
				public void run() {
						while(!(Skriv.getTekst().equals("QUIT"))){
						System.out.println(Skriv.getTekst());
						
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
				}
		});
		
		Skriving.start();
		Urtskrift.start();
	
		
	}
}
