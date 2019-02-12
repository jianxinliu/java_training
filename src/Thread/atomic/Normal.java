package Thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/** 
 * 多线程并发对一个值进行读写
 * @author ljx
 * @Date Jan 17, 2019 9:25:07 AM
 *
 */
public class Normal {
	
	private int a = 0;
	private volatile int b = 0;
	private AtomicInteger c = new AtomicInteger(0);
	/**
	 * 三个步骤：
	 * 	1. 读取 a 的值
	 *  2. 执行 a + 1
	 *  3. 执行 a =  a + 1
	 *  这是哪个步骤如果不是作为一个原子执行，则在多线程环境下就可能会出现问题。
	 */
	public void add(String name) {
//		a++;
		// 放大这个步骤,故意添加延迟
		int b = a;
		int delay = (int)(Math.random()*100);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int c = b + 1;
		a = c;
		System.out.print("\n "+name+" "+ a +" delay:"+delay);
	}
	
	/**
	 * 操作 Volatile 变量,
	 * 在自增的过程中强行中断的话，volatile 变量也拯救不了,
	 * TODO: 有待深究.Volatile 修饰的变量不能保证同步性，只能保证可见性。
	 * @param name
	 */
	public void addVolatile(String name) {
		int c = b;
		int delay = (int)(Math.random()*100);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int d = c + 1;
		b = d;
		System.out.print("\n "+name+" "+ b +" delay:"+delay);
	}
	
	/**
	 * 原子化操作
	 * @param name
	 */
	public void addAtomic(String name) {
		AtomicInteger b = c;
		int delay = (int)(Math.random()*100);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.getAndIncrement();
		System.out.print("\n "+name+" "+ c.toString() +" delay:"+delay);
	}
	
	public synchronized void addOne(String name) {
		add(name);
	}
	
	public void getA() {
		System.out.print(" "+ a);
	}
	
	static class GetA implements Runnable{	
		private Normal n ;
		private String name;
		public GetA(Normal n,String name) {
			this.n = n;
			this.name = name;
		}
		@Override
		public void run() {
//			n.add(name);
//			n.addOne(name);
//			n.addVolatile(name);
			n.addAtomic(name);
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		Normal n = new Normal();
		for(int i = 0;i<20;i++) {
			exe.execute(new GetA(n,"p"+i));
		}	
		exe.shutdown();
	}
}
