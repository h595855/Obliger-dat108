package F05Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TellerAtomic extends Thread {

	AtomicInteger at = new AtomicInteger(0);

	public int tellOpp() {
		return at.incrementAndGet();
	}

	public int tellNed() {
		return at.decrementAndGet();
	}
	
	public int verdiGet() {
		return at.get();
	}
}
