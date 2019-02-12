package Thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 应用 1：喝茶线程需要等到买茶叶和烧开水线程完成之后才能执行
 * @author ljx
 * @Date Jan 16, 2019 11:31:13 AM
 *
 */
public class CountDownLatchTest {

	static class DrinkTea implements Runnable{
		
		private CountDownLatch cdl;
		public DrinkTea(CountDownLatch cdl) {
			this.cdl = cdl;
		}
		@Override
		public void run() {
			try {
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("drink tea");
		}
		
	}
	
	static class BuyTea implements Runnable{

		private CountDownLatch cdl;
		public BuyTea(CountDownLatch cdl) {
			this.cdl = cdl;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cdl.countDown();
			System.out.println("go outside buy tea");
		}
		
	}
	
	static class BoilWater implements Runnable{

		private CountDownLatch cdl;
		public BoilWater(CountDownLatch cdl) {
			this.cdl = cdl;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cdl.countDown();
			System.out.println("gu lu gu lu...");
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(3);
		CountDownLatch cdl = new CountDownLatch(2);
		
		exe.execute(new BoilWater(cdl));
		exe.execute(new DrinkTea(cdl));
		exe.execute(new BuyTea(cdl));
		
		exe.shutdown();
	}
}
