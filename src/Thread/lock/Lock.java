package Thread.lock;

/**
 * 模拟锁的实现原理（synchronized）
 * @author ljx
 * @Date Jan 14, 2019 9:21:10 PM
 *
 */
public class Lock {

	/**
	 * 存在于每个对象头中，所以Java中可以使用任何对象作为锁
	 * 原理：
	 * 	线程试图获取锁，也就是试图获取 minitor 的持有权,当计数器的值为 0 时，获取锁成功，
	 * 	获取锁后，将计数器的值加 1 。（在可重入锁中，可以对计数器再执行加的操作）。
	 *  释放锁：将计数器的值减 1 。（在可重如锁中，直到计数器的值为 0 才算释放成功）。
	 */
	static class Monitor{
		public int value = 0;
		public String owner;
		public Monitor() {}
		public Monitor(String o) {
			this.owner = o;
		}
	}
	
	public Monitor monitor = new Monitor();
	
	/**
	 * 获取锁，获取不到返回false
	 * @param o
	 * @return
	 */
	public boolean lock(String o) {
		if(monitor.value != 0) {
			System.out.println("get lock fail!");
			return false;
		}else {
			monitor.owner = o;
			monitor.value++;
			System.out.println("the lock is own to:"+o);
			return true;
		}
	}
	
	/**
	 * 获取锁，一定能获取，暂时获取不到就等待,类似自旋锁
	 * FIXME: 设置自旋时间，超时停止
	 * @param owner
	 */
	public void lock1(String owner) {
		if(monitor.value != 0) {
//			System.out.println(owner+"...");
			while(monitor.value != 0) {
				// 轮询，每 300 ms 查看一下状态
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(owner + " wait.  ");
			}
		}
		System.out.println(owner+" get lock...");
		monitor.owner = owner;
		monitor.value++;
	}
	
	public void unlock() {
		monitor.owner = "";
		monitor.value--;
	}
	
	public static void main(String[] args) {
		Lock lock = new Lock();
		lock.lock("A");
	}
	
}
