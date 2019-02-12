package Thread.communcation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 资源池，线程从这里取数据
 * @author ljx
 * @Date Jan 15, 2019 1:35:16 PM
 *
 */
public class Pool {

	private List<Integer> pool = new ArrayList<Integer>(20);
	public int ptr = 0;
	public Pool() {
		this.pool = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}
	public Integer get() {
		Integer ret = null;
		ret = pool.get(ptr);
		ptr++;
//		try {
//			if(ptr % 2 == 0) {
//				this.wait();
//			}
//			this.notify();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return ret;
	}
}
