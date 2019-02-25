package Thread.singleton.lazyinit;

/**
 * 2.懒初始化。
 * 线程不安全
 * @author ljx
 * @Date Feb 25, 2019 3:57:10 AM
 *
 */
public class SingletonLazy2 {
	
	private SingletonLazy2() {
		// 将初始化时间拉长，则当线程 A 在执行初始化操作时，线程 B 调用 getInstance 时，看到的 instance 变量则是 null，则也会进行初始化操作，单例不再单例
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static SingletonLazy2 instance;
	
	public static SingletonLazy2 getInstance() {
		if(instance == null) {
			instance = new SingletonLazy2();
		}
		return instance;
	}
	
	/** 一次执行结果，每隔一秒打印一行
	 *  Thread.singleton.lazyinit.SingletonLazy@3f31e4b0
		Thread.singleton.lazyinit.SingletonLazy@787bb2f5
		Thread.singleton.lazyinit.SingletonLazy@5f742e6f
		Thread.singleton.lazyinit.SingletonLazy@1827142b
		Thread.singleton.lazyinit.SingletonLazy@6ff4bcf0
		Thread.singleton.lazyinit.SingletonLazy@2215e1a3
		Thread.singleton.lazyinit.SingletonLazy@7a09b80e
		Thread.singleton.lazyinit.SingletonLazy@5e406110
		Thread.singleton.lazyinit.SingletonLazy@1ef28727
		Thread.singleton.lazyinit.SingletonLazy@5acddca4
	 */
}
