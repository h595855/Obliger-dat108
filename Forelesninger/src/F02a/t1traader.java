package F02a;

public class t1traader {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		Runnable r = new minRunnable();
		
		for(int i = 1; i <= 10; i++) {
			Thread t = new Thread(r, "Tråd #" + i);
			t.start();
		}
		
	}

}

class minRunnable implements Runnable{

	@Override
	public void run() {
		String navn = Thread.currentThread().getName();
		System.out.println("Hallo fra " + navn);
	}
	
}
