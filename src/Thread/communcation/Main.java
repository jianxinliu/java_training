package Thread.communcation;

/**
 * 使用 synchronized 实现线程通信
 * @author ljx
 * @Date Jan 15, 2019 1:34:10 PM
 *
 */
public class Main {

	public static void main(String[] args) {
		Pool pool = new Pool();
		Thread1 t1 = new Thread1(pool);
		Thread2 t2 = new Thread2(pool);
		t1.start();
		t2.start();
	}
}
