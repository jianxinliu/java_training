package Thread.lock;

/**
 *
 * @author ljx
 * @Date Jan 14, 2019 9:43:19 PM
 *
 */
public class Main {

	public static void main(String[] args) {
		Lock lock = new Lock();
//		new TwoThread(lock,900,"B ").start();
//		new TwoThread(lock,900,"A ").start();
		new Thread2(lock,"A").start();
		new Thread2(lock,"B").start();
	}
}
