package Thread.semaphore;

/**
 * 简单模拟信号量操作
 * @author ljx
 * @Date Jan 16, 2019 11:34:09 AM
 *
 */
public class JxSemaphore {

	private static int SEM;
	private int semaphore;

	public JxSemaphore(int se) {
		this.SEM = se;
		this.semaphore = se;
	}

	public void acquire() {
		if(semaphore >= 1) {
			semaphore--;
		}else {
			while(semaphore >= 1) {
				semaphore--;
			}
		}
	}

	public void acquire(int count) {
		if(semaphore >= count) {
			semaphore -= count;
		}else {
			while(semaphore >= count) {
				semaphore -= count;
			}
		}
	}

	public void release() {
		if(semaphore + 1 > SEM) {
			System.out.println("wrong...");
			return;
		}else {
			semaphore++;
		}
	}

	public void release(int count) {
		if(semaphore + count > SEM) {
			System.out.println("wrong...");
			return;
		}else {
			semaphore+=count;
		}
	}
}
