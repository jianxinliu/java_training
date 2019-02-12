package Thread;

import java.util.ArrayList;

/**
 *
 * @author ljx
 * @Date Jan 13, 2019 1:17:45 PM
 *
 */
public class ThreadTest2 {

	static Array arr = new Array(new ArrayList<Integer>(0));
	static Productor pro = new Productor(arr);
	static Consumer con = new Consumer(arr);
	
	public static void main(String[] args) {
		pro.start();
		con.start();
	}
}
