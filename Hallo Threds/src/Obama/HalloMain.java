package Obama;

public class HalloMain {

	public static void main(String[] args) throws InterruptedException {
		
//  #1	Thread t = new MinTraad();
		
//	#2	Thread t = new Thread() {
//			@Override
//			public void run() {
//				System.out.println("hallo fra AnonymTraa");
//			}
//			
//		};
		
//	#3	Thread t = new Thread(new MinRunnable());
		
//	#4	Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("hallo fra annonym Runnable");
//			}
//		});
		Thread t = new Thread(() -> System.out.println("hallo fra anonym runnable"));
		
		t.start();
	
		Thread.sleep(6);
		
		System.out.println("Hallo fra main");

	}

}
