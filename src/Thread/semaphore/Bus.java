package Thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 模拟公交车(火车)
 * 
 * @author ljx
 * @Date Jan 16, 2019 10:34:51 AM
 *
 */
public class Bus {

	private final static int SEAT_MAX = 5;

	private Semaphore tickets = new Semaphore(SEAT_MAX);
	private boolean[] used = new boolean[SEAT_MAX];

	public int getSeat() throws InterruptedException {
		tickets.acquire();
		return getAviliableSeat();
	}

	public void debus(int i) {
		markAsUnused(i);
		tickets.release();
	}

	private synchronized int getAviliableSeat() {
		for (int i = 0; i < SEAT_MAX; i++) {
			if (!this.used[i]) {
				used[i] = true;
				return i + 1;
			}
		}
		return -1;
	}

	private synchronized void markAsUnused(int i) {
		this.used[i - 1] = false;
	}
}
