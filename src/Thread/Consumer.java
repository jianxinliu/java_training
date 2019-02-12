package Thread;

/**
 *
 * @author ljx
 * @Date Jan 13, 2019 1:20:26 PM
 *
 */
@SuppressWarnings(value = { "unused"})
public class Consumer extends Thread {

	private Array arr;

	public Consumer(Array arr) {
		this.arr = arr;
	}

	@Override
	public void run() {
//      test1();
//		test2();
		test3();
	}
	
	/**
	 * 消费者
	 */
	private void test1() {
		while(true) {
			try {
				arr.pop();
				System.out.println("pop one............");
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 无序偶数打印
	 */
	private void test2() {
		arr.even();
	}
	
	/**
	 * 有序偶数打印
	 */
	private void test3() {
		for (int i = 0; i < 10; i++) {
			arr.evenOrder();
		}
	}

}
