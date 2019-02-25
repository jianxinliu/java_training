package Thread.singleton.lazyinit;

/** 
 * 懒初始化。对 SingletonLazySyncDCL4 的改进，使用 volatile 关键字改进线程间可见性
 * @author ljx
 * @Date Feb 25, 2019 4:28:15 AM
 *
 */
public class SingletonSyncDCLVolatile5 {

	private SingletonSyncDCLVolatile5() {
		System.out.println("new ...........");
		// 将初始化时间拉长。
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// 改进，增加 volatile 关键字
	// 若不加 volatile 关键字，则不保证线程之间的可见性，因为代码中 mark 行不是一个原子操作，而是三个
	// 1. 为 instance 分配内存
	// 2. 初始化 instance（new Singleton()）
	// 3. 将 instance 指向分配好的内存
	// 因为 jvm 有指令重排的特性，所以上面的执行顺序并不能得到保证，若线程 A 的执行顺序为 132，当执行到 13 时，线程 B 进入，此时线程 B 读取到的 instance 
	// 	实际上还没被初始化，但已经指向了一块内存，所以线程 B 返回了一个残缺的 instance 对象，没有被初始化为真正的 Singleton 类
	// 使用 volatile 关键字可以保证线程间的可见性，保证线程在进行读操作时世界去主存读取而不是从缓存中读取。
	
	private volatile static SingletonSyncDCLVolatile5 instance;
	
	public static SingletonSyncDCLVolatile5 getInstance() {
		if (instance == null) {
			synchronized (SingletonLazySync3.class) {
				System.out.println("dc...........");
				if (instance == null) {// DCL (Double Check Locking)
					instance = new SingletonSyncDCLVolatile5();        // mark
				}
			}
		}
		return instance;
	}
}
