package Thread.lock;

/**
 *
 * @author ljx
 * @Date Jan 15, 2019 10:30:28 AM
 *
 */
public class Thread2 extends Thread{

	private Lock lock ;
	private String owner = "";
	public Thread2(Lock lock,String o) {
		this.lock = lock;
		this.owner = o;
	}
	@Override
	public void run() {
		lock.lock1(owner);
		System.out.println(owner+" get the lock...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
		System.out.println(owner+" release the lock...");
	}
}
