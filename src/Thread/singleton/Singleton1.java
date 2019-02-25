package Thread.singleton;

/**
 * 1.立即实例化
 * @author ljx
 * @Date Feb 25, 2019 3:51:26 AM
 *
 */
public class Singleton1 {

	private Singleton1() {}
	
	private static final Singleton1 instance = new Singleton1();
	
	public static Singleton1 getInstance() {
		return instance;
	}
}
