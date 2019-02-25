package Thread.singleton.lazyinit;

/**
 * 懒初始化，使用 DCL 防止多线程环境下重复初始化
 * 
 * @author ljx
 * @Date Feb 25, 2019 4:18:08 AM
 *
 */
public class SingletonLazySyncDCL4 {

	private SingletonLazySyncDCL4() {
		System.out.println("new ...........");
		// 将初始化时间拉长。
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static SingletonLazySyncDCL4 instance;

	public static SingletonLazySyncDCL4 getInstance() {
		if (instance == null) {
			synchronized (SingletonLazySync3.class) {
				System.out.println("dc...........");
				if (instance == null) {// DCL (Double Check Locking)
					// 此处再次检查 instance 是否被赋值
					instance = new SingletonLazySyncDCL4();
				}
			}
		}
		return instance;
	}
	
	/** 一次执行结果，全部执行完只用了一到两秒，只实例化了一次，但是因为实例化时间被拉长，新线程还是不能及时的获取到被更新的值，所以每次都会获取锁
		dc...........
		new ...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
	 */
	
	/** sleep 的时间间隔为 10 毫秒时的一次执行结果，若新线程来时第一个线程已经完成了初始化操作，则后续线程无需获取锁
	 *  dc...........
		new ...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		dc...........
		dc...........
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySyncDCL4@3f31e4b0

	 */
}
