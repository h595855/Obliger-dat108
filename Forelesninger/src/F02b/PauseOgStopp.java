package F02b;

public class PauseOgStopp {

	public static void main(String[] args) throws InterruptedException{

		MinTraad t = new MinTraad("Hei-tråd");
		t.start();
		
		Thread.sleep(5000);
		
		t.stopp();
		
		
	}
}

class MinTraad extends Thread {
	
	boolean fortsette = true;
	
	public MinTraad(String navn) {
		super(navn);
	}
	
	public void stopp() {
		fortsette = false;
	}
	
	@Override
	public void run() {
		while(fortsette) {
			System.out.println("heisann montebello");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
