package Thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 应用 2 ：多任务并行，多个线程在同一时刻执行 类似赛跑，发令枪响，所有运动员开始跑
 * ^~^   ^v^  ^_^  (^&^)  (^*^)  (^o^) <^;^>  <^@^> [^Y^]  @(^Y^)@
 * @author ljx
 * @Date Jan 16, 2019 2:07:45 PM
 *
 */
public class CountDownLatchTest2 {

	static class Runner implements Runnable {
		private CountDownLatch cdl;
		private String name;// 跑者姓名
		private int during;// 跑完所花的时间

		public Runner(CountDownLatch cdl, String name, int during) {
			this.cdl = cdl;
			this.name = name;
			this.during = during;
		}

		@Override
		public void run() {
			try {
				// I am Ready !!!
				cdl.await();
				System.out.println(name + " run...");
				Thread.sleep(during);
				System.out.println(name + " run end....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(5);
		CountDownLatch cdl = new CountDownLatch(1);
		// Ready !!!
		for (int i = 0; i < 5; i++) {
			exe.execute(new Runner(cdl, "r" + (i + 1), (i + 1) * 1000));
		}
		System.out.println("......Pang .....");
		// Go !!!
		cdl.countDown();
		exe.shutdown();
	}
}
