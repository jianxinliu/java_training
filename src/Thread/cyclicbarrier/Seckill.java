package Thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 秒杀应用模拟，使用 Semaphore 和 CyclicBarrier(CountDownLatch 也可以完成)
 * @author ljx
 * @Date Jan 16, 2019 2:33:42 PM
 */
public class Seckill {

	/**
	 * 商品数量有限
	 * @author ljx
	 * @Date Jan 16, 2019 4:27:19 PM
	 *
	 */
	static class Goods{
		private final int MAX = 10;
		private int count = MAX;
		private Semaphore max = new Semaphore(MAX,false);
		
		public int take() throws InterruptedException {
			return max.tryAcquire() ? getNext() : -1;
		}
		
		private synchronized int getNext() {
			count--;
			return 1;
		}
	}
	
	static class Consumer implements Runnable{

		private Goods goods;
		private String name;
		private CyclicBarrier cb;
		public Consumer(Goods goods,String name,CyclicBarrier cb) {
			this.goods = goods;
			this.name = name;
			this.cb = cb;
		}
		@Override
		public void run() {
			try {
				// 假设没有延迟
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			try {
				int yeah = goods.take();
				if(yeah != -1) {
					System.out.println(name + " got "+ yeah);
				}else {
					System.out.println(name + " bad... "+ yeah);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		int parties = 15;
		// 参加的人为 parties 个时，开始秒杀
		CyclicBarrier cb = new CyclicBarrier(parties);
		ExecutorService pool = Executors.newCachedThreadPool();
		Goods g = new Goods();
		for(int i = 0;i<parties;i++) {
			pool.execute(new Consumer(g,"C"+(i+1),cb));
		}
		pool.shutdown();
	}
	
	
}