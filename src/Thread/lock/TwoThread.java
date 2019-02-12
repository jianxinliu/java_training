package Thread.lock;

/**
 *
 * @author ljx
 * @Date Jan 14, 2019 9:44:18 PM
 *
 */
public class TwoThread extends Thread{

	private Lock lock;
	private String me = "";
	private int wait = 0;
	
	public TwoThread(Lock l,int wait,String own) {
		this.lock = l;
		this.wait = wait;
		this.me= own;
	}
	@Override
	public void run() {
		if(lock.lock(me)) {
			lock.monitor.owner = me;
			System.out.println(me + ":own the lock...");
			try {
				// 拿到锁之后做的事情
				Thread.sleep(wait);
				
				lock.unlock();
				System.out.println(me + ":release the lock...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			// 等待锁释放
			while(!lock.lock(me)) {
				// 轮询
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				System.out.print(me + ".  ");
			}
			System.out.println();
			lock.monitor.owner = me;
			System.out.println(me + ":got lock finally...");
			try {
				Thread.sleep(wait);
				lock.unlock();
				System.out.println(me + ":release the lock...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
