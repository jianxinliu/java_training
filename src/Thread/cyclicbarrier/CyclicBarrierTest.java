package Thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 循环栅栏（屏障）。和 CountDownLatch 非常类似，可以实现线程间的等待，但功能更复杂和强大
 * 作用是，让一组线程达到同一个屏障（同步点）时被阻塞，直到最后一个线程到达同步点，才会打开屏障。
 * 
 * 实现游戏中十个玩家的加载，必须每个玩家都加载完成才会开始游戏。
 * 	
 * @author ljx
 * @Date Jan 16, 2019 2:41:45 PM
 *
 */
public class CyclicBarrierTest {

	static class Player implements Runnable {

		private CyclicBarrier cb;
		private String name;
		private int loadLatey;

		public Player(CyclicBarrier cb, String name, int ll) {
			this.cb = cb;
			this.name = name;
			this.loadLatey = ll;
		}

		@Override
		public void run() {
			
			try {
				Thread.sleep(loadLatey);
				System.out.println(name + " Ready....");
				cb.await();
//				System.out.println(name + "............ Done....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			final int TEN = 10;
			ExecutorService exe = Executors.newFixedThreadPool(TEN);
			// CyclicBarrier(int parties, Runnable barrierAction)，当屏障撤销时，需要执行的屏障操作，优先执行barrierAction（parties 个线程）
			CyclicBarrier cb = new CyclicBarrier(TEN,() -> {
				System.out.println("欢迎来到 王者荣耀");
			});
			for (int i = 1; i <= TEN; i++) {
				exe.execute(new Player(cb, "P" + i, i * 1000));
			}			
			exe.shutdown();
		}
	}

}
