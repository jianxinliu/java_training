package Thread.container;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author ljx
 * @Date Jan 17, 2019 1:28:09 PM
 *
 */
public class Test {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);
		bq.add(2);
	}
}
