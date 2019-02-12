package Thread;

/**
 *
 * @author ljx
 * @Date Jan 13, 2019 1:20:01 PM
 *
 */
public class Productor extends Thread {

	public Array arr1;

	public Productor(Array arr) {
		this.arr1 = arr;
	}

	@Override
	public void run() {
//		test1();
//		test2();
		test3();
	}

	/**
	 * 生产者
	 */
	private void test1() {
		while(true) {
			try {
				arr1.push(1);
				System.out.println("push one............");
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 无序打印奇数
	 */
	private void test2() {
		arr1.odd();
	}

	/**
	 * 有序打印奇数
	 */
	private void test3() {
		for (int i = 0; i < 10; i++) {
			arr1.oddOrder();
		}
	}
}
