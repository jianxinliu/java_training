package Thread.communcation;

/**
 *
 * @author ljx
 * @Date Jan 15, 2019 2:25:37 PM
 *
 */
public class Thread2 extends Thread{

	Pool pool;
	public Thread2(Pool p) {
		this.pool = p;
	}
	
    @Override
	public void run() {
//		System.out.println(this.currentThread().getName()+" create.....");
//		System.out.println(currentThread().getName()+"   :   "+pool.get());
		try {
            for (int i = 0; i < 5; i++) {
                synchronized (pool) {
                    if (pool.ptr % 2 == 0)
                    	pool.wait();
                    System.out.println(currentThread().getName()+"   :   "+pool.get());
                    pool.notify();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Oops...");
        }
	}
}
