package Thread.singleton.lazyinit;

/**
 * 3.懒初始化，对初始化代码加 synchronized 关键字保证线程安全
 * @author ljx
 * @Date Feb 25, 2019 4:06:13 AM
 *
 */
public class SingletonLazySync3 {

	private SingletonLazySync3() {
		// 将初始化时间拉长。
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static SingletonLazySync3 instance;
	
	public static SingletonLazySync3 getInstance() {
		if(instance == null) {
			synchronized(SingletonLazySync3.class) {
				// 初始化时间拉长之后，当线程 A 获得锁后，正在执行初始化操作，线程 B 调用 getInstance 方法，判断得到 instance 为 null（因为线程 A 对 instance
				// 的初始化还未完成），所以排队等线程 A 释放锁，B 获得锁之后，又执行 new 操作，单例不再单例。
				instance = new SingletonLazySync3();
			}
		}
		return instance;
	}
	/** 一次执行的结果，每隔一秒打印一行
	 *  Thread.singleton.lazyinit.SingletonLazySync@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazySync@5acddca4
		Thread.singleton.lazyinit.SingletonLazySync@5e406110
		Thread.singleton.lazyinit.SingletonLazySync@7a09b80e
		Thread.singleton.lazyinit.SingletonLazySync@1ef28727
		Thread.singleton.lazyinit.SingletonLazySync@2215e1a3
		Thread.singleton.lazyinit.SingletonLazySync@6ff4bcf0
		Thread.singleton.lazyinit.SingletonLazySync@1827142b
		Thread.singleton.lazyinit.SingletonLazySync@5f742e6f
		Thread.singleton.lazyinit.SingletonLazySync@787bb2f5
	 */
}
