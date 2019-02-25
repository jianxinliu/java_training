package Thread.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Thread.singleton.lazyinit.SingletonLazy2;
import Thread.singleton.lazyinit.SingletonLazySync3;
import Thread.singleton.lazyinit.SingletonLazySyncDCL4;
import Thread.singleton.lazyinit.SingletonSyncDCLVolatile5;

/**
 *
 * @author ljx
 * @Date Feb 25, 2019 3:52:37 AM
 *
 */
public class Test {
	
	static class Vister implements Runnable{

		@Override
		public void run() {
			System.out.println(Singleton1.getInstance());
			System.out.println(SingletonLazy2.getInstance());
			System.out.println(SingletonLazySync3.getInstance());
			System.out.println(SingletonLazySyncDCL4.getInstance());
			System.out.println(SingletonSyncDCLVolatile5.getInstance());
		}
	}

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(10);
		for (int i = 1; i <= 10; i++) {
			exe.execute(new Vister());
		}
		exe.shutdown();
	}
}
